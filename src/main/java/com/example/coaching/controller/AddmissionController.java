package com.example.coaching.controller;

import com.example.coaching.model.AddmissionForm;
import com.example.coaching.service.AddmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admission")
public class AddmissionController {

    private final AddmissionService service;

    public AddmissionController(AddmissionService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddmissionForm> submitForm(@Valid @RequestBody AddmissionForm form) {
        return ResponseEntity.ok(service.submit(form));
    }

    @GetMapping
    public List<AddmissionForm> getAllForms() {
        return service.getAll();
    }
}
