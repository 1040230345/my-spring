package cn.springframework.io;


/**
 * 资源加载器接口
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
