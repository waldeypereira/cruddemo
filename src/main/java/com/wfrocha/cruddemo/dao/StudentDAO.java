package com.wfrocha.cruddemo.dao;


import com.wfrocha.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);

}
