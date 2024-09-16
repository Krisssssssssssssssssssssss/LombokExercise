package org.example;

import java.util.ArrayList;
import java.util.List;

public class UniversityService {
    public static double calculateAvgGradeCourse(Course course) {
        if (course.getStudents() == null || course.getStudents().isEmpty()) {
            return 0.0;
        }
        return course.getStudents().stream().mapToInt(Student::getGrade).average().getAsDouble();
    }
    public static double calculateAvgGradeUniversity(University university) {
        if (university.courses() == null || university.courses().isEmpty()) {
            return 0.0;
        }
        return university.courses()
                 .stream().flatMap(course -> course.getStudents().stream())
                 .mapToInt(Student::getGrade)
                 .average()
                .orElse(0.0);
    }
    public static List<Student> retrieveStudentsWithGradesAboveTwo(University university) {
        List<Student> result = new ArrayList<>();
        university.courses().stream().flatMap(course -> course.getStudents().stream()).filter(student -> student.getGrade() > 2).forEach(result::add);
        return result;
    }
}
