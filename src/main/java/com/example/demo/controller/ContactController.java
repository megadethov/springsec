package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Random;

@RestController
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(LocalDate.now());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
