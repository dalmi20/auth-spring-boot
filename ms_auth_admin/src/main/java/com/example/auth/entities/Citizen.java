package com.example.auth.entities;

import com.example.auth.util.AlgerianNINGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nin;
    private String nationality;
    private String fullName;
    private String famillyName;
    private  String firstName;
    private String dayra;
    private String commune;
    private String wilaya;
    private Date birthdate;
    private  Gender gender;
    private Status status;

}
