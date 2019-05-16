package lesson4.repositories;

import lesson4.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> { //CrudRepository<Student, Long> {

    @Query(value = "select s from Student s where s.score=(select max(ss.score) from Student ss)")
    Student maxQuery();

    @Query(value = "select s from Student s where s.score=(select min(ss.score) from Student ss)")
    Student minQuery();

}
