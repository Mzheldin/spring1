package lesson4.services;

import lesson4.entities.Student;
import lesson4.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void fillTable(){
        for (int i = 1; i <= 20; i++){
            Student student = new Student();
            student.setName("student_" + i);
            student.setScore(50 + i);
            studentRepository.save(student);
        }
    }

    public Page<Student> getAll(int i){
        return studentRepository.findAll(PageRequest.of(i, 10));
    }

    public Student getMaxScore(){
        return studentRepository.maxQuery();
    }

    public Student getMinScore(){
        return studentRepository.minQuery();
    }

}
