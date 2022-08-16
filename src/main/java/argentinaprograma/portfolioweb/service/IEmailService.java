package argentinaprograma.portfolioweb.service;

import argentinaprograma.portfolioweb.dto.EmailDTO;

public interface IEmailService {
    public boolean sendEmail(EmailDTO emailDTO);
}
