package com.yocike.mplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yocike.mplus.entity.User;
import com.yocike.mplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MpController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/aaa")
    @ResponseBody
    public int aa(){
        User user = new User();
        user.setEmail("cerwtime");
        user.setAge(11);
        user.setName("qwejk");

        int insert = userMapper.insert(user);
        System.out.println(insert);
        return insert;
    }
    @RequestMapping("/page")
    public List<User> page(@RequestParam(value = "page")int current,@RequestParam(value = "size")int size){
        Page<User> page = new Page<>(current, size);
        userMapper.selectPage(page, null);
//        List<User> records = userIPage.;

        return page.getRecords();

    }
    @GetMapping("/findall")
    public List<User> findAll(){
        int i = 1/0;
        return userMapper.selectList(null);
    }
}
