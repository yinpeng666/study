package edu.study.ol.course.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import edu.study.ol.bean.EduCourse;
import edu.study.ol.bean.SysFunction;
import edu.study.ol.bean.SysSubject;
import edu.study.ol.course.mapper.EduCourseMapper;
import edu.study.ol.course.mapper.SysSubjectMapper;
import edu.study.ol.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private EduCourseMapper eduCourseMapper;
    @Autowired
    private SysSubjectMapper sysSubjectMapper;

    @Override
    public List<EduCourse> selectAllCourse() {
        List<EduCourse> courseList = eduCourseMapper.selectAll();
        //封装为一个rootList
        return null;
    }

    @Override
    public List<SysSubject> selectAllSubject() {
        List<SysSubject> subjectsList = sysSubjectMapper.selectAll();
        List<SysSubject> rootSubjectList = packageSubject(subjectsList);
        return rootSubjectList;
    }

    @Override
    public int updateSortById(SysSubject sysSubject) {

        int i = sysSubjectMapper.updateByPrimaryKeySelective(sysSubject);
        return i;
    }

    /**
     * 封装SysSubject为一个父对象的集合
     * @param subjectsList
     * @return
     */
    private List<SysSubject> packageSubject(List<SysSubject> subjectsList) {
        Collections.reverse(subjectsList);
        List<SysSubject> rootList = new ArrayList<>();
        Map<Integer,SysSubject> allMap = new HashMap<>();
        for (SysSubject subject : subjectsList) {
            allMap.put(subject.getSubjectId(),subject);
        }
        for (SysSubject sysSubject : subjectsList) {
            if (sysSubject.getParentId()==0){
                rootList.add(sysSubject);
            }else {
                Integer parentId = sysSubject.getParentId();
                SysSubject subjectParent = allMap.get(parentId);
                subjectParent.getChildList().add(sysSubject);
            }

        }
        return rootList;

    }
}
