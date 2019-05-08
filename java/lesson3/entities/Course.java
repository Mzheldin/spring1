package lesson3.entities;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "courses_students",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns =@JoinColumn(name = "student_id")
    )
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<CoursesStudents> coursesStudents;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Student o : students) stringBuilder.append(" ").append(o.getName());
        return "Course [" + id + " " + name + " students: " + stringBuilder.toString() +"]";
    }

}
