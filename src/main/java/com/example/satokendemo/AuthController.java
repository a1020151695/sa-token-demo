package com.example.satokendemo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Cola
 * @description
 * @date 2022/1/4
 * @email 1020151695@qq.com
 */
@RestController
public class AuthController {

    /**
     * @description satoken下的用户登录
     * @author cola
     * @url /interview/inviteList
     * @method GET
     */
    @RequestMapping("/login")
    public SaResult login(String username, String password){
        if("admin".equals(username)&&"123456".equals(password)){
            // 与StpInterfaceImpl中重写的方法照应
            StpUtil.login(101);
            Map<String,String> map = new HashMap<>();
            map.put("token", StpUtil.getTokenValue());
            // 返回token
            return SaResult.data(map);
        }
        return SaResult.error("登录失败");
    }

    @RequestMapping("/isLogin")
    public String isLogin(){
        return "当前会话是否登陆：" + StpUtil.isLogin();
    }

    @RequestMapping("/getToken")
    public SaResult getToken(){
        return SaResult.data(StpUtil.getTokenValue());
    }

    @RequestMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @RequestMapping("/hello")
    public String hello(){
        if(StpUtil.hasPermission("user-get")) return "hello";
        else return "nothing";
    }

    // 实例就到这吧，其余的按照文档走就行

}
