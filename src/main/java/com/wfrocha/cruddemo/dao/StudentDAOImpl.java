package com.wfrocha.cruddemo.dao;

import com.wfrocha.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        // Return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "FROM Student s WHERE s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<String> findAllLastNames() {
        return entityManager.createQuery(
                        "SELECT s.lastName FROM Student s order by lastName", String.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        int numRowsDeleted = entityManager.createQuery(
                        "DELETE FROM Student s WHERE s.id = :studentId")
                .setParameter("studentId", id)
                .executeUpdate();
        System.out.println("Deleted " + numRowsDeleted + " student(s) with id: " + id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("Deleted " + numRowsDeleted + " student(s)");
        return numRowsDeleted;
    }


}
