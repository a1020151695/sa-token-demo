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
     * satoken - 注解式鉴权 - 校验当前用户身份 - 具体实现
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        Integer userId = Integer.parseInt(loginId.toString());
        List<String> list = new ArrayList<>();
        /**
         * 必看！
         * 根据userId，从数据库获取该用户的role,放入list并返回，这里不实际连接数据库，而是做一个mock
         */
//      String role = userMapper.getRole(userId);
//      list.add(role);

        // 这里模拟出一个student的role
        if(userId == 1){
            list.add("student");
        }
        return list;
    }
}
