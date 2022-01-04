package com.example.satokendemo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 登录认证
 */
@RestController
@RequestMapping("/")
public class AuthController {


    @RequestMapping("login")
    public SaResult login(String username, String password){
        if("admin".equals(username)&&"123456".equals(password)){
            StpUtil.login(101); // 与StpInterfaceImpl中重写的方法对应
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    @RequestMapping("isLogin")
    public String isLogin(){
        return "当前会话是否登陆：" + StpUtil.isLogin();
    }

    @RequestMapping("getToken")
    public SaResult getToken(){
        return SaResult.data(StpUtil.getTokenValue());
    }

    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @RequestMapping("hello")
    public String hello(){
        if(StpUtil.hasPermission("user-get")) return "hello";
        else return "nothing";
    }

    // 实例就到这吧，其余的按照文档走就行

}
