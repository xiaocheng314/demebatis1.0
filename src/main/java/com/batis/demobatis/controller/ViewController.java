package com.batis.demobatis.controller;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import com.batis.demobatis.entity.User;
import com.batis.demobatis.service.impl.LostGoodsServiceImpl;
import com.batis.demobatis.service.impl.PickGoodsServiceImpl;
import com.batis.demobatis.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月22日 21:21
 * @version: 1.0
 */
@Controller
@RequestMapping("goods")
public class ViewController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private LostGoodsServiceImpl lostGoodsService;
    @Autowired
    private PickGoodsServiceImpl pickGoodsService;

    @RequestMapping("login")
    public String login() {
        return "index";
    }

    @RequestMapping("user")
    public String user(Model model) {
        List<User> userList = userService.selectAll();
        model.addAttribute("userList", userList);
        return "user";
    }

    @RequestMapping("lost")
    public String lost(Model model) {
        List<LostGoods> lostGoodsList = lostGoodsService.selectLostAll();
        model.addAttribute("lostList", lostGoodsList);
        return "lost";
    }

    @RequestMapping("pick")
    public String pick(Model model) {
        List<PickGoods> pickGoodsList = pickGoodsService.selectAllPick();
        model.addAttribute("pickList", pickGoodsList);
        return "pick";
    }

    //    @RequestMapping("check/{id}")
//    public String check(@PathVariable Integer id) {
//        System.out.println(id);
//        userService.deleteById(id);
//        return "redirect:/goods/user";
//    }
    @RequestMapping("check")
    public String check(@RequestParam(required = false,value = "id") String id) {
        System.out.println(id);
        userService.deleteById(id);
        return "redirect:/goods/user";
    }
}


