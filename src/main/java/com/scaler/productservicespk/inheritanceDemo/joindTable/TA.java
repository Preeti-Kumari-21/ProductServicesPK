package com.scaler.productservicespk.inheritanceDemo.joindTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "join_TA")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private int numberOfSessions;
}
