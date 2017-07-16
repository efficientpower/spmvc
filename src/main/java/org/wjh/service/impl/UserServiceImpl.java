package org.wjh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wjh.common.HelloNotifier;
import org.wjh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HelloNotifier helloNotifier;
    
    public String getUserName(String userId) {
        // TODO Auto-generated method stub
        helloNotifier.send();
        return "wangjihui";
    }

}
