package org.sa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@Configuration
public class GatewayConfiguration {
    @Bean(name="webFluxConversionService")
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        //bean.setConverters(...); //add converters
        bean.afterPropertiesSet();
        return bean.getObject();
    }
}
