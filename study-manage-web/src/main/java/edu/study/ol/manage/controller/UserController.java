package edu.study.ol.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import edu.study.ol.bean.EduUser;
import edu.study.ol.bean.SysFunction;
import edu.study.ol.bean.SysSubject;
import edu.study.ol.service.CourseService;
import edu.study.ol.service.UserService;
import edu.study.ol.util.Page;
import edu.study.ol.util.QueryPageParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class UserController {

    @Reference
    private UserService userService;
    @Reference
    private CourseService courseService;


    @RequestMapping("index")
    public String index(HttpServletRequest request){
        List<SysFunction> sysFunctionList = userService.selectAllSysfunction();
        System.out.println(sysFunctionList);
        request.setAttribute("sysFunctionList",sysFunctionList);
        return "index";
    }

    @RequestMapping("admin/user/getuserList")
    public String toUserList(){

        return "userList";
    }

    @RequestMapping("queryUser")
    @ResponseBody
    public Set<EduUser> queryUser(EduUser eduUser){

        Set<EduUser> userList= userService.selectUser(eduUser);
        return userList;
    }

    @RequestMapping("queryUserPage")
    @ResponseBody
    public Map<String,Object> queryUserPage(QueryPageParam queryPageParam){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("pageno",queryPageParam.getPageno());
        param.put("pagesize",queryPageParam.getPagesize());
        param.put("queryText",queryPageParam.getQueryText());

        EduUser eduUser = new EduUser();
        if (queryPageParam.getLastSystemTime()==null){
            eduUser.setLastSystemTime(new Date(9999,9,9));
        }else {

            eduUser.setLastSystemTime(queryPageParam.getLastSystemTime());
        }
        if (queryPageParam.getCreateTime()==null){
            eduUser.setCreateTime(new Date(0,0,0));
        }else {

            eduUser.setCreateTime(queryPageParam.getCreateTime());
        }
        eduUser.setIsAvalible(queryPageParam.getAvalible());

        param.put("eduUser",eduUser);
        System.out.println(queryPageParam.getCreateTime());
        try {
            Page<EduUser> page = userService.selectUserPage(param);
            result.put("data",page);
            result.put("success",true);
        } catch (Exception e) {
            result.put("success",false);
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("editPassword")
    @ResponseBody
    public String editPassword(EduUser eduUser){
        String result = userService.updateByPrimaryKey(eduUser);
        return result;
    }

    @RequestMapping("/admin/user/toBatchOpen")
    public String toBatchOpen(){
        return "BatchOpenUser";
    }

    @RequestMapping("admin/subj/toSubjectList")
    public String toSubjectList(HttpServletRequest request){
        List<SysSubject> subjectList = courseService.selectAllSubject();
        request.setAttribute("subjectList",subjectList);
        return "subject/SubjectList";
    }

    @RequestMapping("changeSort")
    public String changeSort(String subjectId,String sort){
        int subId=Integer.parseInt(subjectId);
        int sor=Integer.parseInt(subjectId);
        SysSubject sysSubject = new SysSubject();
        sysSubject.setSort(sor);
        sysSubject.setSubjectId(subId);
        int result = courseService.updateSortById(sysSubject);
        if (result<=0){
            return "false";
        }
        return "success";
    }

    @RequestMapping("changeAvalible")
    @ResponseBody
    public String changeAvalible (EduUser eduUser){
        eduUser.setIsAvalible(!eduUser.getIsAvalible());
        String s = userService.updateByPrimaryKey(eduUser);
        return s;

    }

}
