package com.wfrocha.cruddemo.dao;


import com.wfrocha.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    List<String> findAllLastNames();

    void update(Student theStudent);

    void deleteById(Integer id);

    int deleteAll();




}
