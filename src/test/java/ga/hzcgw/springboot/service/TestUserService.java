package ga.hzcgw.springboot.service;

import ga.hzcgw.springboot.Starter;
import ga.hzcgw.springboot.query.UserQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
public class TestUserService {
    private Logger logger = LoggerFactory.getLogger(TestUserService.class);


    @Resource
    private UserService userService;

    @Before
    public void before() {
        logger.info("单元测试之前");
    }

    @Test
    public void test01() {
        logger.info("用户记录 {}", userService.queryUserById(1).toString());
    }

    @Test
    public void test02() {
        logger.info("用户记录 {}", userService.queryUserByParams(new UserQuery("admin")).toString());
    }

    @After
    public void after() {
        logger.info("单元测试之后");
    }

}
