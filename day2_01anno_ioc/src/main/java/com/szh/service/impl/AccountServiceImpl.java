package com.szh.service.impl;

import com.szh.dao.AccountDao;
import com.szh.service.AccountService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * 账户的业务层实现类
 *
 * xml的方式
 *  <bean id="accountService" class="com.szh.service.impl.AccountServiceImpl"
 *        scope=""  init-method="" destroy-method="">
 *      <property name="" value=""/ref=""></property>
 *  </bean>
 *
 *  注解
 *  用于创建对象的
 *      Component:用于把当前类对象存入Spring容器种
 *         属性value：用于指定bean的id（默认值为当前类名且首字母小写）
 *       Controller：表现层
 *       Service：业务层
 *       Repository：持久层
 *         以上三个注解作用和属性与Component相同
 *  用于注入数据的
 *      AutoWired:用于自动按照类型注入,当只有一个匹配类型时，直接注入，多个时按照变量名匹配容器key值，否则报错
 *      Qualifier:按照类注入的基础上，在按照名注入，给类成员注入时不能单独使用，但给方法参数注入时可以
 *      Resource:直接按照bean的id注入，可以独立使用
 *      以上三个注入都只能注入其他bean类型的数据
 *      集合类型只能通过xml配置来实现
 *
 *      value：用于注入基本类型和String类型的数据
 *              属性：value用于指定数据的值，
 *  用于改变作用范围
 *      Scope:属性value（singleton/prototype）
 *  和生命周期相关
 *      PreDestroy:用于指定销毁方法
 *      PostConstruct：用于指定初始化方法
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao2")
    private AccountDao accountDao;

    @PostConstruct
    public  void init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
