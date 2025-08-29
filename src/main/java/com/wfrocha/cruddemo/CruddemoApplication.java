package com.wfrocha.cruddemo;

import com.wfrocha.cruddemo.dao.StudentDAO;
import com.wfrocha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

            // createMultipleSetudents(studentDAO);

            // readStudent(studentDAO);

            queryForStudents(studentDAO);


        };
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // Get a list of students

        List<Student> theStudents = studentDAO.findAll();

        // Display list of students

        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }

    }


    private void createMultipleSetudents(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Waldey", "Rocha", "waldey@gmail.com");
        Student tempStudent2 = new Student("Mary", "Public", "marypublic@gmail.com");
        Student tempStudent3 = new Student("John", "Doggy", "john@gmail.com");

        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);


    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating a new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "wfrocha@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Creating a new student object ...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + myStudent);


    }

}
