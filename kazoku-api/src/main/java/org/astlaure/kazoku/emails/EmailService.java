package org.astlaure.kazoku.emails;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final Configuration configuration;

    public EmailService(JavaMailSender mailSender, Configuration configuration) {
        this.mailSender = mailSender;
        this.configuration = configuration;
    }

    public void sendEmail(Email email) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setFrom(email.getFrom());
            mimeMessageHelper.setTo(email.getTo());
            String emailContent = getContentFromTemplate(email.getTemplate().value, email.getModel());
            mimeMessageHelper.setText(emailContent, true);

            mailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | TemplateException | IOException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplate(String template, Map< String, Object > model) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();

        configuration.getTemplate(template).process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
