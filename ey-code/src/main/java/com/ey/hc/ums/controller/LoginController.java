package com.ey.hc.ums.controller;

import com.ey.hc.common.enums.ResultCode;
import com.ey.hc.common.api.ResultJson;
import com.ey.hc.ums.dto.LoginFrom;
import com.ey.hc.ums.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoginFrom loginFrom;

//    @PostMapping("/login")
//    public ResultJson login() {
//        String token=userInfoService.findByName(loginFrom.getUsername(),loginFrom.getPassword());
//        if (token == null){
//            return RetResponse.faile(ResultCode.USER_LOGIN_ERROR);
//        }
//        Map<String,String> map= new HashMap<>();
//        map.put("token",token);
//        return  RetResponse.success(map, ResultCode.SUCCESS);
//    }
  //  }
}