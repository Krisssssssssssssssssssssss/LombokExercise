package org.example;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@With
public class Student {
     int id;
    String name;
    int grade;
    String adress;
}
