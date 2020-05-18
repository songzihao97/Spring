package com.szh.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂
 *
 * Bean：在计算机英语中有可重用组件的含义
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个Map，用于存放我们要创建的对象，称之为容器
    private static Map<String,Object> beans;
    //定义静态代码块为properties赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的Key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    /**
     * 根据Bean名称获取bean对象
     * @param beanName
     * @return
     */
/*     public static Object getBean(String beanName){
        Object bean=null;
        try {
            String beanPath=props.getProperty(beanName);
            bean=Class.forName(beanPath).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
     }*/
}
