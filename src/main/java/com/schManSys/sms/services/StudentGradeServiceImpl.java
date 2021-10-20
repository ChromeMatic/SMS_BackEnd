package com.schManSys.sms.services;

import com.schManSys.sms.models.Student;
import com.schManSys.sms.models.StudentGrades;
import com.schManSys.sms.repository.StudentGradesRepository;
import com.schManSys.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;
import javax.transaction.Transactional;
import java.util.Collection;

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

        if(isNull(student) && isNull(grades) ){
          log.error("Student does not exist");
        }

        student.getGradesSet().add(grades);

    }

    @Override
    public StudentGrades FindById(Long studentGradeId) {
        return studentGradesRepository.findByStudentGradeId(studentGradeId);
    }

    @Override
    public Collection<StudentGrades> FindStudentGradeByStudentName(String studentName) {

        Student student = studentRepository.findByStudentName(studentName);

        if(isNull(student)){
          log.info("Student named: {}, does not exist.",studentName);
        }

        Collection<StudentGrades> grades = student.getGradesSet();

        return grades;
    }
}
