package com.batis.demobatis.util;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述: 获取openid的组件
 *
 * @author : cjf
 * @date : 2020/8/28 9:04
 */
@Component
public class WxChatResolveUtil {
    @Value("${param.wx_url}")
    private String wxUrl;

    public String getOpenid(String jsCode) throws HttpProcessException {
        //判断是否为空
        if (StringUtils.isBlank(jsCode)) {
            return ResultEnum.WX_RESULT_RESOLVE_MSG_ERROR.getMessage();
        }else {
            //解析url
            String url = wxUrl.replace("JSCODE", jsCode);
            JSONObject jsonObject = JSONObject.parseObject(HttpClientUtil.get(HttpConfig.custom().url(url)));
            System.out.println(url);
            if (jsonObject.containsKey("errcode")) {
                return ResultEnum.WX_RESULT_RESOLVE_MSG_ERROR.getMessage();
            }else {
                String openid =  jsonObject.getString("openid");
                return openid;
            }
        }
    }
}
