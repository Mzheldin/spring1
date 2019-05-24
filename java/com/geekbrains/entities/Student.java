package com.geekbrains.entities;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studentss")
@Data
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "students_coursess",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})
    private List<Course> courses;

    @Override
    public String toString() {
        return "Student id=" + id + ", courses=" + courses.size() + '}';
    }
}
