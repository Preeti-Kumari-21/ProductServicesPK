package com.scaler.productservicespk.inheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_Mentor")
public class mentor extends User{
    private String company;
}
