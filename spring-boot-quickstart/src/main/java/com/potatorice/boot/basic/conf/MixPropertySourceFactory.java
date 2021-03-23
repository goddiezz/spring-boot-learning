package com.potatorice.boot.basic.conf;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Properties;

/**
 * @author PotatoRice
 * @description：
 * @date 2021/3/11 2:31 下午
 */
public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name,
                                                  EncodedResource resource)
            throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName != null
                && (sourceName.endsWith(".yml") || sourceName.endsWith((".yaml")))) {

            Properties propertiesFromYaml = loadYml(resource);
            //将YML配置转成properties之后，再用PropertiesPropertySource绑定
            return new PropertiesPropertySource(sourceName, propertiesFromYaml);
        } else {
            return super.createPropertySource(name, resource);
        }
    }

    //将YML格式的配置转成Properties配置
    private Properties loadYml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
