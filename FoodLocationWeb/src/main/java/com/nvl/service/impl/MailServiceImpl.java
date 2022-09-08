package com.nvl.service.impl;

import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.User;
import com.nvl.repository.UserRepository;
import com.nvl.service.MailService;
import com.nvl.service.UserService;

import freemarker.template.Configuration;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private Configuration freemarkerConfiguration;

    @Override
    public void sendEmail(final int type, final String email, final Map<String, Object> object) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() 
        {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
                helper.setTo(email);
                if(type == 1) helper.setSubject("THASNK FOR YOUR PURCHASE"); 
                else if(type == 2) helper.setSubject("SORRY FOR DENY ORDER");
                else if(type == 3) helper.setSubject("YOUR FOLLOW STORE HAVE NEW MENU");
//                helper.setText(message);
                String text = geFreeMarkerTemplateContent(type, object);
                helper.getMimeMessage().setContent(text, "text/html;charset=utf-8");
            }
        };

        try {
            this.javaMailSender.send(preparator);
            System.out.println("Message Sent...Hurrey");
        } catch (Exception exe) {
            exe.printStackTrace();
        }
    }
    
    public String geFreeMarkerTemplateContent(int type, final Map<String, Object> object) {
        StringBuffer content = new StringBuffer();
        try {
            switch (type){
                case 1:
                    content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("ThanksEmail.html"), object));
                    break;
                case 2:
                    content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("SorryEmail.html"), object));
                    break;
                case 3:
                    content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("NewMenu.html"), object));
                    break;
            }
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
