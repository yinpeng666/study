package edu.study.ol.user.mapper;

import edu.study.ol.bean.EduUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface EduUserMapper extends Mapper<EduUser> {

    List<EduUser> selectUserPage(Map<String, Object> param);

    Integer selectTotalsize(Map<String, Object> param);
}
