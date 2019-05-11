package lesson3.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "courses_students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns =@JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @OneToMany(mappedBy = "student")
    private List<CoursesStudents> coursesStudents;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Course o : courses) stringBuilder.append(" ").append(o.getName());
        return "Student [" + id + " " + name + " courses: " + stringBuilder +"]";
    }

}
