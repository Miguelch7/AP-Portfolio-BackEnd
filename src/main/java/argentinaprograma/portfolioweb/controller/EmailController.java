package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.dto.EmailDTO;
import argentinaprograma.portfolioweb.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @PostMapping("/send")
    @ResponseBody
    public boolean SendEmail(@RequestBody EmailDTO emailDTO) {
        return iEmailService.sendEmail(emailDTO);
    }
}
