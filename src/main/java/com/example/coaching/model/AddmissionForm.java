package com.example.coaching.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddmissionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full Name is Required")
    private String name;

    @NotBlank(message = "Phone No is Required")
    private String phone;

    @Email(message = "Invalid Email Format")
    private String email;
    private String studentClass;

    @Column(columnDefinition = "TEXT")
    private String message;
    private LocalDateTime submittedAt;
}
