package com.movies.info.moviesinfo.service;

import com.movies.info.moviesinfo.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailCreatorService mailCreatorService;

    public void send(final Mail mail){
        LOGGER.info("Starting email preparation...");
        try{
            SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(mailMessage);
//            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been sent.");

        } catch (Exception e){
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail, final String userCode, final String login){
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mailCreatorService.buildRegistrationEmail(mail.getMessage(), userCode, login), true);
        };
    }

    private SimpleMailMessage createMailMessage(final Mail mail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if(mail.getToCC() != null){
            mailMessage.setCc(mail.getToCC());
        }
        return mailMessage;
    }

    public void send(Mail mail, String userCode, String login) {
        LOGGER.info("Starting email preparation...");
        try{
            javaMailSender.send(createMimeMessage(mail, userCode, login));
            LOGGER.info("Email has been sent.");

        } catch (Exception e){
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }
    }
}
