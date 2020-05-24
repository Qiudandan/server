package com.justdoit.keller.service;

import com.justdoit.keller.entity.UserInfo;
import com.justdoit.keller.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * 使用 @Service 注解将 UserService 类标注为一个业务组件
 * 业务层组件负责具体业务逻辑处理，调用持久层方法完成数据读写，将操作结果返回给控制层
 */
@Service
public class UserService {
    // 使用 @Resource 将 UserMapper 组件注入进来，在后续代码中可以直接使用 userMapper 来执行有关 user_info 表的增删改查操作
    @Resource
    private UserMapper userMapper;

    // 调用 UserMapper 组件的 selectAll() 方法查询所有用户数据
    public List<UserInfo> getAll() {
        return userMapper.selectAll();
    }
}