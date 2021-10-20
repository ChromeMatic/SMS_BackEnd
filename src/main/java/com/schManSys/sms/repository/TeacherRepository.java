package com.schManSys.sms.repository;

import com.schManSys.sms.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findByTeacherId (Long teacherId);
    Teacher findByTeacherName (String teacherName);
}
