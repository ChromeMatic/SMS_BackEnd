package com.schManSys.sms.services;

import com.schManSys.sms.models.Teacher;
import com.schManSys.sms.repository.StudentGradesRepository;
import com.schManSys.sms.repository.StudentRepository;
import com.schManSys.sms.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final StudentGradesRepository studentGradesRepository;

    @Override
    public Teacher SaveNewTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findByTeacherId(teacherId);
    }

    @Override
    public Teacher getTeacherByName(String teacherName) {
        return teacherRepository.findByTeacherName(teacherName);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
}
