package lesson3.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "courses_students")
@Data
public class CoursesStudents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "lesson_count")
    private int lesson_count;

    @Column(name = "score")
    private int score;

}
