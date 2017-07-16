package org.wjh.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjh.service.UserService;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/wjh/hello.do")
    public Object hello() throws IOException {
        Map<String, Object> res = new HashMap<String, Object>();

        res.put("name", "wjh");
        res.put("age", 27);
        return res;
    }
}
