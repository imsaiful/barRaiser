package com.example.bar.bar.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    private String id;
    private String name;
    private String phoneNumber;
    private boolean onCall;
    private String teamId;
}
