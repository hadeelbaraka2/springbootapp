
package com.baraka.Springboot.controller;

import com.baraka.Springboot.Repositories.StudentRepository;
import com.baraka.Springboot.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/students")
public class Controller {
    
    @Autowired
    StudentRepository studentrepository;


    @GetMapping
    public List<Student> all() {
        return studentrepository.findAll();
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable int id) {
        return studentrepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student s) {
        return studentrepository.save(s);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student s) {
        Student current = studentrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
        current.setMajor(s.getMajor());
        current.setName(s.getName());
        current.setGrade(s.getGrade());
        return studentrepository.save(current);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studentrepository.deleteById(id);
    }
}
