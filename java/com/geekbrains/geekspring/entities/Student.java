package com.geekbrains.geekspring.entities;

import com.geekbrains.geekspring.validation.ValidEmail;
import com.geekbrains.geekspring.validation.ValidPhone;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})
    private List<Course> courses;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "last_name")
    private String lastName;

    @ValidEmail
    @NotNull(message = "is required")
    @Size(min = 5, message = "is required")
    @Column(name = "email")
    private String email;

    @Column(name = "reg_data")
    private String regData;

    @ValidPhone
    @NotNull(message = "is required")
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student id=" + id + ", courses=" + courses.size() + '}';
    }
}
