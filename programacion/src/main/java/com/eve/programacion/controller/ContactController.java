
package com.eve.programacion.controller;
import com.eve.programacion.entity.ContactForm;
import com.eve.programacion.repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
      @Autowired
  private JavaMailSender mailSender;
      
 @Autowired
  private ContactFormRepository contactFormRepository;

  @PostMapping("/contacto")
  public void sendContactForm(@RequestBody ContactForm contactForm) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(contactForm.getEmail());
    message.setTo("evelynpenfold94@gmail.com"); 
    message.setSubject("Nuevo mensaje de " + contactForm.getName());
    message.setText(contactForm.getMessage());
    mailSender.send(message);
    
    contactFormRepository.save(contactForm);
  }
}
