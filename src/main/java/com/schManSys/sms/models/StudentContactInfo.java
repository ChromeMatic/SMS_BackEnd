package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name ="studentParentContactInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentContactId;
    private String email;
    private String phoneNumber;
    private String address;
}
