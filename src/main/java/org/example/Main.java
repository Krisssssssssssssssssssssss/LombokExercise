package org.example;
//Step 1: Add the Lombok dependency to your project and configure IntelliJ to support Lombok.
//
//        Step 2: Create a simple class "Student" with the following attributes: id, name, address, grade.
//
//        Step 2.5: Use the appropriate Lombok annotations to generate getters, setters, equals, hashCode, toString, and constructors for the entity.
//
//Step 3: Create a Teacher record with the following attributes: id, name, subject.
//
//        Step 4: Create a class Course with the following attributes: id, name, teacher, students.
//
//        Step 4.5: Use the appropriate Lombok annotations to generate getters, setters, equals, hashCode, toString, and constructors for the entity.
//
//Step 5: Write a "Main" class where you apply some examples of creating Students, Teachers, and Courses using the constructors.
//
//Step 6: In the "Main" class, check if the generated Lombok methods work correctly (getter, setter, toString, ...)

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1,"John", 2, "SomeStreet");
        Student student2 = new Student(2,"Jane", 3, "OtherStreet");

        Student student3 = Student.builder()
                .id(1)
                .name("Bob")
                .build();
        System.out.println("builtStudent = " + student3);
        Student student4 = student3.withAdress("Third adress");
        System.out.println("withStudent = " + student4);

        Teacher teacher = new Teacher(1, "Sam", "Math");
        Course course = new Course(1, "Linear Algebra", teacher, List.of(student1, student2));

       System.out.println("The course " + course.getName() + " is taught by teacher: " + course.getTeacher().name() + ", and its students are: " + course.toString()) ;
       System.out.println("The course " + course.getName() + " is taught by teacher: " + course.getTeacher().name() + ", and its students are: " + course.getStudentsString()) ;

        //Bonus
        University university1 = new University(1, "Stuttgart Uni", List.of(course));
        System.out.println("Average grade of the course: " + UniversityService.calculateAvgGradeCourse(course));
        System.out.println("Average grade in the University: " + UniversityService.calculateAvgGradeUniversity(university1));
        System.out.println("Students with grade above 2: " + UniversityService.retrieveStudentsWithGradesAboveTwo(university1));

    }
}