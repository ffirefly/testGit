package com.firefly.test;

import com.firefly.dao.AccountDao;
import com.firefly.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.List;

public class testMybatis {
    @Test
    public void testMybatis() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> all = dao.findAll();
        for(Account account:all){
            System.out.println(account);
        }


    }
    @Test
    public void testMybatis2() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        //List<Account> all = dao.findAll();
        //保存账户信息
        Account account = new Account();
        account.setName("Angela");
        account.setMoney(10000d);
        dao.saveAccount(account);
        session.commit();
        List<Account> all = dao.findAll();
        for(Account ac:all){
            System.out.println(ac);
        }


    }
}
