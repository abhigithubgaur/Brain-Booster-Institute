package com.example.coaching.service;

import com.example.coaching.model.AddmissionForm;
import com.example.coaching.repository.AddmissionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddmissionService {

    private final AddmissionFormRepository repository;

    private final EmailService emailService;

    public AddmissionService(AddmissionFormRepository repository, EmailService emailService){
        this.repository = repository;
        this.emailService = emailService;
    }

    public AddmissionForm submit(AddmissionForm form){
        form.setSubmittedAt(LocalDateTime.now());
        AddmissionForm savedForm = repository.save(form);

        emailService.sendAdmissionNotification(savedForm);

        return form;
    }

    public List<AddmissionForm> getAll(){
        return repository.findAll();
    }




}
