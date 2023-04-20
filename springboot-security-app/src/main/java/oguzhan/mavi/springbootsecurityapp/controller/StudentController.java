package oguzhan.mavi.springbootsecurityapp.controller;

import oguzhan.mavi.springbootsecurityapp.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private  List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> students()
    {

        // created student1 object
        Student student1= new Student();

        //create student1 field set value
        student1.setId(1);
        student1.setFirstName("Oguzhan");
        student1.setLastName("Mavi");

        //create student1 field set value
        Student student2= new Student();

        //create student12field set value
        student2.setId(2);
        student2.setFirstName("Beytullah");
        student2.setLastName("Mavi");

        students.add(student1);
        students.add(student2);
        return students;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student)
    {
        students.add(student);
        return student;
    }

}
