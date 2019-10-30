package com.service;

import com.dao.impl.UserMapperImpl;
import com.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author JinLu
 */
public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        //创建dao层对象 当前dao层实现是手动编写的
        UserMapperImpl userMapper = new UserMapperImpl();
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }
}
