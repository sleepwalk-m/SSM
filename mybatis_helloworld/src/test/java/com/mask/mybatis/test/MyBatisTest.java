package com.mask.mybatis.test;

import com.mask.mybatis.mapper.UserMapper;
import com.mask.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author: Mask.m
 * @create: 2022/09/06 21:08
 * @description:
 */
public class MyBatisTest {


    @Test
    public void testInsert() throws Exception{

        // 获取核心配置文件输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取sqlsessionfactorybuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 构建sqlsessionfactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 构建sqlsession对象  true:自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取定义的mapper接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行方法
        int i = mapper.insertUser();
        System.out.println("i = " + i);

        // 提交事务
        //sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpateOrDelete() throws Exception{


        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取定义的mapper接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行方法
        //int i = mapper.updateUser();
//        System.out.println("i = " + i);
        mapper.deleteUser();
        // 关闭会话
        sqlSession.close();


    }
}
