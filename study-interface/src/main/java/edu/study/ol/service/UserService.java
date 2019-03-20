package edu.study.ol.service;

import edu.study.ol.bean.EduUser;
import edu.study.ol.bean.SysFunction;
import edu.study.ol.util.Page;
import edu.study.ol.util.QueryPageParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    List<SysFunction> selectAllSysfunction();

    List<EduUser> selectAllUser();

    Set<EduUser> selectUser(EduUser eduUser);

    String updateByPrimaryKey(EduUser eduUser);

    Page<EduUser> selectUserPage(Map<String,Object> param);
}
