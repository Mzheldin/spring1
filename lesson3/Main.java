package lesson3;

import lesson3.entities.Course;
import lesson3.entities.CoursesStudents;
import lesson3.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(CoursesStudents.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        //получение объекта из бд
//        session.beginTransaction();
//        Student student = session.get(Student.class, 1);
//        System.out.println(student);
//        session.getTransaction().commit();
//        session.close();
//
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Course course = session.get(Course.class, 2);
//        System.out.println(course);
//        session.getTransaction().commit();
//        session.close();

        //удаление объекста
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        session.delete(session.get(Student.class, 1));
////        int res = session.createQuery("delete Student where name = :param").setParameter("param","student1").executeUpdate();
//        session.getTransaction().commit();
//        session.close();

        //получение дополнительной информации с помощью запросов
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        String student_name = "student1";
//        Student student = (Student) session
//                .createQuery("from Student s where s.name = :student_name")
//                .setParameter("student_name", student_name)
//                .getSingleResult();
//        student.toString();
//        System.out.println(student.getId());
//        String course_name = "course1";
//        Course course =(Course) session
//                .createQuery("from Course c where c.name = :course_name")
//                .setParameter("course_name", course_name)
//                .getSingleResult();
//        course.toString();
//        CoursesStudents coursesStudents =(CoursesStudents) session
//                .createQuery("from CoursesStudents cs where cs.student = :student_id and cs.course = :course_id")
//                .setParameter("student_id", student)
//                .setParameter("course_id", course)
//                .getSingleResult();
//        System.out.println("студент " + student.getName() + " прошел " + coursesStudents.getLesson_count()
//                + " занятий по курсу " + course.getName() + " и его текущий балл равен " + coursesStudents.getScore());
//        session.getTransaction().commit();
//        session.close();

        //получение дополнительной информации с помощью объекта таблицы курсы-студенты
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class, 3);
//        if (student != null) {
//            String courseName = "3";
//            CoursesStudents coursesStudents = null;
//            for (CoursesStudents o : student.getCoursesStudents()) {
//                if (o.getCourse().getName().equals(courseName)) coursesStudents = o;
//                break;
//            }
//            if (coursesStudents != null)
//                System.out.println("Студент " + student.getName() + " прошел " + coursesStudents.getLesson_count()
//                        + " занятий по курсу " + coursesStudents.getCourse().getName() + " и его текущий балл равен "
//                        + coursesStudents.getScore());
//            else System.out.println("Студент " + student.getName() + " не проходил курса " + courseName);
//        } else System.out.println("Студента с таким id не существует");
//        session.getTransaction().commit();
//        session.close();
    }
}
