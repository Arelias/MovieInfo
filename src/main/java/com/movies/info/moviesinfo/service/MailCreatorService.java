package com.movies.info.moviesinfo.service;

import com.movies.info.moviesinfo.config.AdminConfig;
import com.movies.info.moviesinfo.config.WebsiteConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Qualifier("templateEngine")
    private final TemplateEngine templateEngine;

    private final AdminConfig adminConfig;

    private final WebsiteConfig websiteConfig;

    public MailCreatorService(TemplateEngine templateEngine, AdminConfig adminConfig, WebsiteConfig websiteConfig) {
        this.templateEngine = templateEngine;
        this.adminConfig = adminConfig;
        this.websiteConfig = websiteConfig;
    }

    public String buildRegistrationEmail(String message, String code, String login){
        List<String> functionality = new ArrayList<>();
        functionality.add("You can browse for movies");
        functionality.add("Create your own movies lists");
        functionality.add("Get insight data on producers, box office revenue, etc.");

        Context context = new Context();
        context.setVariable("app_functionality", functionality);
        context.setVariable("user_name", login);
        context.setVariable("message", message);
        context.setVariable("user_url", "http://localhost:8080/users/confirm/" + code);
        context.setVariable("button", "Confirm email");
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("goodbye_message", "Best regards");
        context.setVariable("company_details",
                "Website name: " +
                websiteConfig.getWebsiteName() + "." +
                        "Website owner: " +
                adminConfig.getAdminName() + " " +
                        "Website goal: " +
                websiteConfig.getWebsiteGoal() + ".");
        context.setVariable("preview_message", "Please confirm your email adress.");
        return templateEngine.process("mail/user-activation-mail", context);
    }
}
