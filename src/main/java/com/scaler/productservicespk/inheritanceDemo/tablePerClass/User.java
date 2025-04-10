package com.scaler.productservicespk.inheritanceDemo.tablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.Identity;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "table_per_class_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
}
