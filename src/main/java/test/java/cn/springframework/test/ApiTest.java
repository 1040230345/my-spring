package test.java.cn.springframework.test;


import cn.springframework.BeanDefinition;
import cn.springframework.BeanFactory;
import org.junit.Test;
import test.java.cn.springframework.test.bean.UserService;

/**
 * 测试
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){

        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 3.获取 bean

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
