package org.example;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Value
public class Course {
    int id;
    String name;
    Teacher teacher;
    List<Student> students;

    public String getStudentsString() {
        StringBuilder result = new StringBuilder();
        students.forEach(student -> result.append(student.getName().toString()).append(", "));

        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
