package edu.study.ol.util;

import org.hibernate.validator.internal.util.privilegedactions.GetMethodFromPropertyName;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class CommonUtil {
    /**
     * 判断一个对象中的所有属性是否为null
     * @param obj
     * @return
     * @throws Exception
     */
    public static boolean isAllFieldNull(Object obj) throws Exception{
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = true;
        for (Field f : fs) {//遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Object val = f.get(obj);// 得到此属性的值
            String str = null;

            Type genericType = f.getGenericType();
            //如果该属性为String类型
            if ("class java.lang.String".equals(genericType)){
                String name = f.getName();
                String methodName ="get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method m = (Method) obj.getClass().getMethod(methodName);
                str = (String) m.invoke(obj);// 调用getter方法获取属性值
            }

            boolean a = (val!=null);
            boolean b = (!"".equals(str)&&str!=null);
            boolean c = (!"null".equals(str));
            if(a && b && c) {//只要有1个属性不为空,那么就不是所有的属性值都为空 && val!="" && val!="null"
                flag = false;
                break;
            }
        }
        return flag;
    }
}
