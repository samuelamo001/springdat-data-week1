package springdata.week1.springdata.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.entitie.Student;
import springdata.week1.springdata.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @CacheEvict(value = "all_students", key = "'students'")
    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }

    @Cacheable(value = "all_students", key = "'students'")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
