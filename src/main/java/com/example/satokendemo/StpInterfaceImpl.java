package com.example.satokendemo;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    /**
     * satoken - 注解式鉴权 - 校验当前用户身份的impl
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        Integer userId = Integer.parseInt(loginId.toString());
        /**
         * 根据userId获取该用户的role,放入list并返回
         */
//        String role = userMapper.getRole(userId);
//        List<String> list = new ArrayList<>();
//        list.add(role);
//        return list;
        return null;
    }
}
