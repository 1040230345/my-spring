package test.java.cn.springframework.test;


import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import test.java.cn.springframework.test.bean.UserService;

/**
 * 测试
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){

        // 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 第二次获取 bean
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

}
