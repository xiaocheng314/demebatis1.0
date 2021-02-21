package com.batis.demobatis.controller;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.batis.demobatis.entity.User;
import com.batis.demobatis.service.impl.UserServiceImpl;
import com.batis.demobatis.util.Result;
import com.batis.demobatis.util.ResultEnum;
import com.batis.demobatis.util.WxChatResolveUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 用户表(User)表控制层
 *
 * @author lc
 * @since 2020-05-12 19:00:33
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    WxChatResolveUtil wxChatResolveUtil;
    /**
     * 服务对象
     */
    @Autowired
    private UserServiceImpl userService;

    /**
     * 授权登录，返回uuid，前端保存，用uuid进行传递
     * 登陆失败，返回登录错误，请重新登录
     * 登录成功，uuid
     *
     * @param jsCode
     * @return
     */
    @RequestMapping(value = "userInsert", method = RequestMethod.POST)
    public Result userInsert(@RequestParam(required = false, value = "jsCode") String jsCode) throws HttpProcessException {
        //jscode为空返回
        if (StringUtils.isBlank(jsCode)) {
            return Result.Error(ResultEnum.WX_RESULT_RESOLVE_MSG_ERROR, "数据有错");
        } else {
            String result = wxChatResolveUtil.getOpenid(jsCode);
            //获取openid失败返回
            if (ResultEnum.WX_RESULT_RESOLVE_MSG_ERROR.getMessage().equals(result)) {
                return Result.Error(ResultEnum.ERROR, "jsCode失败");
            }
            //成功则添加到数据库
            String uuId = UUID.randomUUID().toString();
            User user = userService.insert(uuId, result);
            //删除openid
            user.setOpenId(null);
            return Result.success(user);
        }
    }

    /**
     * 登录后，修改注册信息，
     * 修改信息，返回0为报错，
     * 修改成功，返回1
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "userUpdate", method = RequestMethod.POST)
    public Result userUpdate(@RequestBody(required = false) User user) {
        if (user == null) {
            return Result.Error(ResultEnum.RESULT_LOST_GOODS_NULL, null);
        }
        int result = 0;
        if (user.getUuId() != null) {
            if (userService.queryById(user.getUuId()) != null) {
                result = userService.update(user);
            }
        }
        if (result == 0) {
            return Result.Error(ResultEnum.RESULT_LOST_GOODS_NULL, null);
        }
        return Result.success(userService.update(user));
    }

}
