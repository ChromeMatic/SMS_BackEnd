package com.schManSys.sms.services;

import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.StudentGrades;
import com.schManSys.sms.repository.StudentGradesRepository;
import com.schManSys.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentGradeServiceImpl implements StudentGradeService{

    private final StudentRepository studentRepository;
    private final StudentGradesRepository studentGradesRepository;

    @Override
    public StudentGrades AddNewStudentGrade(StudentGrades studentGrades) {
        return  studentGradesRepository.save(studentGrades);
    }

    @Override
    public void EditStudentGrade(Long studentId, StudentGrades studentGrades) {

        Student student =  studentRepository.findByStudentId(studentId);
        StudentGrades grades =  studentGradesRepository.findByStudentGradeId(studentGrades.getStudentGradeId());

        student.getGradesSet().add(grades);
    }

    @Override
    public StudentGrades FindById(Long studentGradeId) {

        StudentGrades grades = studentGradesRepository.findByStudentGradeId(studentGradeId);

        return grades;
    }

    @Override
    public List<StudentGrades> FindByStudentId(Long studentId) {

        Student student = studentRepository.findByStudentId(studentId);

        List<StudentGrades> gradesList = student.getGradesSet();

        return gradesList;
    }

    @Override
    public List<StudentGrades> FindStudentGradeByStudentName(String studentName) {

        Student student = studentRepository.findByStudentName(studentName);

        List<StudentGrades> grades = student.getGradesSet();

        return grades;
    }
}
