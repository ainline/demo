package com.alchen;

import com.alchen.spring.jdbctemplate.config.SpringConfiguration;
import com.alchen.spring.jdbctemplate.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class JdbcTemplateTest {

    @Autowired
    IAccountService accountService;

    @Test
    public void testFind() {
        accountService.findAllAccount();
    }
}
