package edu.study.ol.service;

import edu.study.ol.bean.EduCourse;
import edu.study.ol.bean.SysSubject;

import java.util.List;

public interface CourseService {
    List<EduCourse> selectAllCourse();

    List<SysSubject> selectAllSubject();

    int updateSortById(SysSubject sysSubject);
}
