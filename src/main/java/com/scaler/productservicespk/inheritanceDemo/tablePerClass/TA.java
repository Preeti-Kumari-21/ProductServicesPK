package com.scaler.productservicespk.inheritanceDemo.tablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "table_per_class_TA")
public class TA extends User {
    private int numberOfSessions;
}
