package com.alchen.test;

import com.alchen.demo.spring.aop.config.SpringConfiguration;
import com.alchen.demo.spring.aop.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AopTest {

//    @Autowired
//    private IAccountService as = null;

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService accountService;

    @Test
    public void testTransfer() {

        accountService.transfer("ge", "chen", 100f);
//        as.transfer("chen", "ge", 100f);

    }
}
