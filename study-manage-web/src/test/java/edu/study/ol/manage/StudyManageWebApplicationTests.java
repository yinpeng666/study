package edu.study.ol.manage;

import edu.study.ol.bean.EduUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyManageWebApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        EduUser eduUser = new EduUser();
        eduUser.setEmail("");
        eduUser.setUserName("了肯德基");
        Object obj = (Object)eduUser;
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        System.out.println(declaredFields);
        boolean flag = true;
        for (Field f : declaredFields) {//遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Object val = f.get(obj);// 得到此属性的值
            System.out.println("属性值:"+ val);
            String str = null;

            String genericType = f.getGenericType().toString();
            System.out.println("属性类型"+genericType);
            //如果该属性为String类型
            if ("class java.lang.String".equals(genericType)){
                String name = f.getName();
                System.out.println("属性名"+genericType);
                String methodName ="get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method m = (Method) obj.getClass().getMethod(methodName);
                str = (String) m.invoke(obj);// 调用getter方法获取属性值
            }

            boolean a = (val!=null);
            boolean b = (!"".equals(str));
            boolean c = (!"null".equals(str));
            if(a && b && c) {//只要有1个属性不为空,那么就不是所有的属性值都为空 && val!="" && val!="null"
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    @Test
    public void sddd(){
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
             new Thread(() -> {
                 list.add(UUID.randomUUID().toString().substring(0,3));
                 System.out.println(list);
             },String.valueOf(i)).start();

        }

    }

}
