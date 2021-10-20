package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "schoolReport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolReportId;
    private String schoolName;
    @OneToOne
    private School school;
    private String performance;
}
