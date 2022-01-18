package test.java.cn.springframework.test;


import cn.springframework.beans.PropertyValue;
import cn.springframework.beans.PropertyValues;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanReference;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import test.java.cn.springframework.test.bean.GoodsService;
import test.java.cn.springframework.test.bean.UserService;

/**
 * 测试
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){

        // 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("goodsService", new BeanDefinition(GoodsService.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("goodsService",new BeanReference("goodsService")));
        propertyValues.addPropertyValue(new PropertyValue("name","杰松"));

        // 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 第一次获取 bean
        UserService bean = (UserService) beanFactory.getBean("userService");
        bean.queryUserInfo();
        bean.getGoodsService().buy();


    }

}
