/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
<<<<<<< HEAD
import com.nvl.validator.MenuValidator;
import com.nvl.validator.RegisterValidator;
import com.nvl.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;
=======
>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.nvl.controllers",
    "com.nvl.repository",
    "com.nvl.service",
    "com.nvl.validator",})
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/resources/assets/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/assets/fonts/");

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver r = new InternalResourceViewResolver();
        r.setPrefix("/WEB-INF/jsp/");
        r.setSuffix(".jsp");
        r.setViewClass(JstlView.class);

        return r;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "djgexdpxq",
                "api_key", "564911839957893",
                "api_secret", "Z5PxnO3G75eMDuoN_itQEn9GImc",
                "secure", true
        ));

        return c;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasenames("messages");

        return m;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());

        return localValidatorFactoryBean;
    }
<<<<<<< HEAD
    
    @Bean("registerValidator")
    public WebAppValidator registerValidator() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new RegisterValidator());

        WebAppValidator webAppValidator = new WebAppValidator();
        webAppValidator.setValidators(springValidators);

        return webAppValidator;
    }
    
    @Bean("menuValidator")
    public WebAppValidator menuValidator() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new MenuValidator());

        WebAppValidator webAppValidator = new WebAppValidator();
        webAppValidator.setValidators(springValidators);

        return webAppValidator;
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasenames("messages");
        
        return m;
    }
=======
>>>>>>> 93f483c0ffbaf3f5a17d6a9587d9abdbe8473081

//    @Bean
//    public WebAppValidator registerValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new RegisterValidator());
//
//        WebAppValidator webAppValidator = new WebAppValidator();
//        webAppValidator.setValidators(springValidators);
//
//        return webAppValidator;
//    }
//
//    @Bean
//    public WebAppValidator menuValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new MenuValidator());
//
//        WebAppValidator webAppValidator = new WebAppValidator();
//        webAppValidator.setValidators(springValidators);
//
//        return webAppValidator;
//    }
}
