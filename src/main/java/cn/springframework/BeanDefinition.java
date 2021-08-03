package cn.springframework;

/**
 * bean定义（spring源码中类名一样）
 * jackson
 * 2021年08月03日23:49:32
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
