package com.infoshareacademy.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
public class Teacher {

    @Id
    @NotNull
    @Column(name = "pesel", length = 11, unique=true)
    private String pesel;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @ManyToMany
    @JoinTable(name = "TEACHERS_TO_COURSES",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "pesel"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"teacher_id", "course_id"}))
    private List<Course> courses;

    public Teacher() {

    }

    public Teacher(String pesel, String name, String surname, List<Course> courses) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", courses=" + courses +
                '}';
    }
}
