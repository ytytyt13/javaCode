package com.qunar.spring入门;

import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author yang
 * 2021年02月19日 20:45:00
 */
public class TradeContextLoaderListener extends ContextLoaderListener {
    @Override
    protected void customizeContext(ServletContext servletContext,
                                    ConfigurableWebApplicationContext applicationContext) {
        super.customizeContext(servletContext, applicationContext);
        XmlWebApplicationContext context = (XmlWebApplicationContext) applicationContext;
        context.setAllowBeanDefinitionOverriding(false);
    }
}

