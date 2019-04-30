package com.infoshareacademy.dao;

import com.infoshareacademy.model.Teacher;
import com.sun.tools.javac.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;
    public String save (Teacher teacher) {
        entityManager.persist(teacher);
        return teacher.getPesel();
    }

    public Teacher update (Teacher teacher) {
        return entityManager.merge(teacher);
    }

    public void delete (String pesel) {
        final Teacher t = entityManager.find(Teacher.class, pesel);
        if (t != null) {
            entityManager.remove(t);
        }
    }

    public Teacher findByPesel (String pesel) {
        return entityManager.find(Teacher.class, pesel);
    }

    public List<Teacher> findAll() {
        final Query query = entityManager.createQuery("SELECT t FROM Teacher t");
        return query.getResultList();
    }
}
