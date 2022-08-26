package com.nvl.configs;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nvl")
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("trungthong2001@gmail.com");
        mailSender.setPassword("nxbzmoaiptleizwr");
        mailSender.setDefaultEncoding("utf-8");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");
        javaMailProperties.put("mail.smtp.starttls.required", "true");
        javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
    
    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration()
    {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setDefaultEncoding("UTF-8");
        bean.setTemplateLoaderPaths("classpath:/mailtemplate/");
        return bean;
    }
}
