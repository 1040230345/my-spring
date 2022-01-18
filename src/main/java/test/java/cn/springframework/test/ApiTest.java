package test.java.cn.springframework.test;


import cn.springframework.beans.PropertyValue;
import cn.springframework.beans.PropertyValues;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanReference;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.springframework.io.DefaultResourceLoader;
import org.junit.Before;
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

//    private DefaultResourceLoader resourceLoader;
//
//    @Before
//    public void init() {
//        resourceLoader = new DefaultResourceLoader();
//    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件&注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取 Bean 对象调用方法
        UserService userService = beanFactory.getBean("UserService", UserService.class);
        userService.queryUserInfo();
    }

}
