package com.scaler.productservicespk.inheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_TA ")
public class TA extends User{
    private int numberOfSessions;
}
