package edu.study.ol.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import edu.study.ol.bean.EduUser;
import edu.study.ol.bean.SysFunction;
import edu.study.ol.service.UserService;
import edu.study.ol.user.mapper.EduUserMapper;
import edu.study.ol.user.mapper.SysFunctionMapper;
import edu.study.ol.util.CommonUtil;
import edu.study.ol.util.Page;
import edu.study.ol.util.QueryPageParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysFunctionMapper sysFunctionMapper;

    @Autowired
    private EduUserMapper eduUserMapper;



    @Override
    public List<SysFunction> selectAllSysfunction() {
        List<SysFunction> rootList = new ArrayList<>();
        List<SysFunction> sysFunctionList = sysFunctionMapper.selectAll();
        Map<Integer,SysFunction> allMap = new HashMap<>();

        for (SysFunction sysFunction : sysFunctionList) {
            allMap.put(sysFunction.getFunctionId(),sysFunction);
        }

        for (SysFunction sysFunction : sysFunctionList) {
            if (sysFunction.getParentId()==0){
                rootList.add(sysFunction);
            }else {
                Integer parentId = sysFunction.getParentId();
                SysFunction functionParent = allMap.get(parentId);
                if (functionParent == null){
                    rootList.add(sysFunction);
                }else {

                    functionParent.getChildrenList().add(sysFunction);
                }
            }
        }
        return rootList;
    }

    @Override
    public List<EduUser> selectAllUser() {
        List<EduUser> eduUsers = eduUserMapper.selectAll();
        return eduUsers;
    }

    /*@Override
    public Set<EduUser> selectUser(EduUser eduUser) {
        try {

            if (eduUser == null||isAllNull(eduUser)){
                List<EduUser> userList = eduUserMapper.selectAll();
                Set<EduUser> userSet = new HashSet<>(userList);
                return userSet;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //根据email查询
        EduUser queryByEmail = getNewUser(eduUser);
        queryByEmail.setEmail(eduUser.getEmail());
        List<EduUser> emailList = eduUserMapper.selectByKey(queryByEmail);

        //根据mobile查询
        EduUser queryBymobile = getNewUser(eduUser);
        queryBymobile.setMobile(eduUser.getMobile());
        List<EduUser> mobileList = eduUserMapper.selectByKey(queryBymobile);

        //根据userName查询
        EduUser queryByUserName = getNewUser(eduUser);
        queryByUserName.setUserName(eduUser.getUserName());
        List<EduUser> userNameList = eduUserMapper.selectByKey(queryByUserName);

        //根据showName查询
        EduUser queryByShowName = getNewUser(eduUser);
        queryByShowName.setShowName(eduUser.getShowName());
        List<EduUser> showNameList = eduUserMapper.selectByKey(queryByUserName);

        //整合查询结果
        Set<EduUser> userSet = IntegrationUserList(emailList,mobileList,userNameList,showNameList);

        return userSet;
    }*/

    @Override
    public String updateByPrimaryKey(EduUser eduUser) {
        int i = eduUserMapper.updateByPrimaryKeySelective(eduUser);
        return i+"";
    }

    @Override
    public Page<EduUser> selectUserPage(Map<String,Object> param) {
        Page<EduUser> page = new Page<>();
        Integer pageno = (Integer) param.get("pageno");
        page.setPageno(pageno);

        Integer pagesize = (Integer) param.get("pagesize");
        page.setPagesize(pagesize);

        int startindex = page.getStartindex();
        param.put("startindex",startindex);
        List<EduUser> userList = eduUserMapper.selectUserPage(param);
        page.setDatas(userList);

        Integer totalsize = eduUserMapper.selectTotalsize(param);
        page.setTotalsize(totalsize);
        return page;
    }

    private boolean isAllNull(EduUser eduUser) {
        Boolean isAvalible = eduUser.getIsAvalible();
        Date createTime = eduUser.getCreateTime();
        String email = eduUser.getEmail();
        Date lastSystemTime = eduUser.getLastSystemTime();
        boolean flag = true;
        boolean a = (isAvalible!=null);
        boolean b = (createTime!=null);
        boolean c = (email!=null&&!"".equals(email));
        boolean d = (lastSystemTime!=null);
        if (isAvalible!=null||createTime!=null||(email!=null&&!"".equals(email))||lastSystemTime!=null){
            flag = false;
        }
        return flag;
    }

    @Override
    public Set<EduUser> selectUser(EduUser eduUser) {

        return null;
    }

    /**
     * 把lastSystemTime，createTime，isAvalible封装入Example
     * @param eduUser
     * @return
     */
    private Example getExample(EduUser eduUser) {
        Example example = new Example(EduUser.class);
        example.createCriteria().andLessThan("lastSystemTime",eduUser.getLastSystemTime());
        example.createCriteria().andGreaterThan("createTime",eduUser.getCreateTime());
        example.createCriteria().andEqualTo("isAvalible",eduUser.getIsAvalible());
        return example;
    }


    /*private void a11111111(EduUser eduUser){
        try {
            if (eduUser == null||CommonUtil.isAllFieldNull(eduUser)){
                List<EduUser> userList = eduUserMapper.selectAll();
                Set<EduUser> userSet = new HashSet<>(userList);
                return userSet;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }*/

    private Set<EduUser> IntegrationUserList(List<EduUser> emailList, List<EduUser> mobileList, List<EduUser> userNameList, List<EduUser> showNameList) {
        Set<EduUser> userSet = new HashSet<>();
        Map<Integer,EduUser> userMap = new HashMap();
        for (EduUser eduUser : emailList) {
            userMap.put(eduUser.getUserId(),eduUser);
        }
        for (EduUser eduUser : mobileList) {
            userMap.put(eduUser.getUserId(),eduUser);
        }
        for (EduUser eduUser : userNameList) {
            userMap.put(eduUser.getUserId(),eduUser);
        }
        for (EduUser eduUser : showNameList) {
            userMap.put(eduUser.getUserId(),eduUser);
        }
        userSet.addAll(userMap.values());
        return userSet;
    }

    private EduUser getNewUser(EduUser eduUser) {
        EduUser queryByEmail = new EduUser();

        queryByEmail.setIsAvalible(eduUser.getIsAvalible());
        queryByEmail.setCreateTime(eduUser.getCreateTime());
        queryByEmail.setLastSystemTime(eduUser.getLastSystemTime());
        return queryByEmail;
    }



}
