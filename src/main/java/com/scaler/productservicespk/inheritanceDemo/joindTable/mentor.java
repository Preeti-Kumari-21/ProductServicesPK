package com.scaler.productservicespk.inheritanceDemo.joindTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class mentor extends User {
    private String company;
}
