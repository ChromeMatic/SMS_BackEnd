package com.schManSys.sms.services;

import com.schManSys.sms.models.Student;
import com.schManSys.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student AddNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student FindStudentById(Long studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public Student FindStudentByName(String studentName) {
        return studentRepository.findByStudentName(studentName);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
