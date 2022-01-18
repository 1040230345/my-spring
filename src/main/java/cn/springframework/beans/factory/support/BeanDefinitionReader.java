package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.io.Resource;
import cn.springframework.io.ResourceLoader;

/**
 * bean定义读取接口
 */
public interface BeanDefinitionReader {

    //获取单例注册
    BeanDefinitionRegistry getRegistry();

    //获取资源加载器
    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
