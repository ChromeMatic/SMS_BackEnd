package com.schManSys.sms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Table
@Entity(name = "school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;
    @OneToOne
    private Region region;
    private String schoolName;
    private String schoolAddress;
    @OneToMany
    private Collection<SchoolReport> schoolReport = new ArrayList<>();
}
