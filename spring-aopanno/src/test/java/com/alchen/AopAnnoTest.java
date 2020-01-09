package com.alchen;

import com.alchen.spring.aopanno.config.SpringConfiguration;
import com.alchen.spring.aopanno.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml")   //使用xml注入
@ContextConfiguration(classes = SpringConfiguration.class)  //使用java配置文件注入，可以省略XML配置文件
public class AopAnnoTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void test(){
        accountService.saveAccount();
    }
}
