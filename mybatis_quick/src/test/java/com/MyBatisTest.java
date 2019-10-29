package com;

import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    //删除操作
    public void test4() throws IOException {

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作  参数：namespace+id
        sqlSession.delete("userMapper.delete", 4);
        //释放资源
        sqlSession.close();
    }

    @Test
    //修改操作
    public void test3() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(4);
        user.setUsername("lucy");
        user.setPassword("123");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作  参数：namespace+id
        sqlSession.update("userMapper.update", user);
        //释放资源
        sqlSession.close();
    }

    @Test
    //增加操作
    public void test2() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("userMapper.add", user);
        System.out.println(insert);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //查询操作
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
}
