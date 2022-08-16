package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender sender;

    @Override
    public boolean sendEmail(EmailDTO emailDTO) {
        LOGGER.info("Email Body: {}", emailDTO.toString());
        return sendEmailTool(emailDTO.getContent(), emailDTO.getEmail(), emailDTO.getSubject());
    }

    private boolean sendEmailTool(String testMessage, String email, String subject) {
        boolean send = false;

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(email);
            helper.setText(testMessage, true);
            helper.setSubject(subject);
            sender.send(message);
            send = true;
            LOGGER.info("Email enviado!");
        } catch (MessagingException e) {
            LOGGER.error("Hubo un error al enviar el mail: {}", e);
        }

        return send;
    }
}
