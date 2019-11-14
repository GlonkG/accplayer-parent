package com.congee.controller;
import com.congee.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

@Component
public class SendMail {
    Logger logger = LoggerFactory.getLogger(SendMail.class);
    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @RabbitListener(queues = "mailqueue")
    public void mail(User user) {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id",user.getUid() );
        String emailContent = templateEngine.process("Mail", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("用户"+user.getUserNickname()+"正在激活中");
            mimeMessageHelper.setFrom(MAIL_SENDER);
            mimeMessageHelper.setTo("3183084220@qq.com");//发给可卿
            StringBuilder str = new StringBuilder();
            str.append(emailContent);
            mimeMessageHelper.setText(str.toString(), true);
            mimeMessageHelper.setText(emailContent,true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("邮件发送失败", e.getMessage());
        }

    }
}
