package com;

import com.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //设置分页相关参数
        PageHelper.startPage(1,1);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获得与分页相关的参数
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        System.out.println("当前页" + userPageInfo.getPageNum());
        System.out.println("每页显示条数" + userPageInfo.getPageSize());
        System.out.println("总条数" + userPageInfo.getTotal());
        System.out.println("总页数" + userPageInfo.getPages());
        sqlSession.close();
    }
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User condition = new User();
        //condition.setId(1);
        condition.setUsername("zhangsan");
        //condition.setPassword("123");

        //List<User> userList = mapper.findByCondition(condition);

        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }

}
