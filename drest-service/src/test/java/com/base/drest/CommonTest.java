package com.base.drest;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * CommonTest
 * @author zhouyw
 * @date 2018.04.18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationService.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional //测试下：默认事务都回滚
public class CommonTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
