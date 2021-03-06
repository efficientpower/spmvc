package org.wjh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wjh.common.HelloNotifier;
import org.wjh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HelloNotifier helloNotifier;
    
    public UserServiceImpl() {
        // TODO Auto-generated constructor stub
        System.out.println("UserServiceImpl 构造方法");
    }

    public String getUserName(String userId) {
        // TODO Auto-generated method stub
        System.out.println("===============execute UserServiceImpl.getUserName()");
        return "wangjihui";
    }

    public String getUserId(String userId) {
        // TODO Auto-generated method stub
        System.out.println("===============execute UserServiceImpl.getUserId()");
        helloNotifier.send();
        return userId;
    }

    public String getAll() {
        // TODO Auto-generated method stub
        System.out.println("===============execute UserServiceImpl.getAll()");
        return "wangjihui" + 1/0;
    }

}
