package com.xq.tmall.service.impl;

import com.xq.tmall.dao.UserMapper;
import com.xq.tmall.entity.User;
import com.xq.tmall.service.UserService;
import com.xq.tmall.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;
    @Resource(name = "userMapper")
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean add(User user) {
        return userMapper.insertOne(user)>0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateOne(user)>0;
    }

    @Override
    public List<User> getList(String user_name, PageUtil pageUtil) {
        return userMapper.select(user_name,pageUtil);
    }

    @Override
    public User get(Integer user_id) {
        return userMapper.selectOne(user_id);
    }

    @Override
    public User login(String user_name, String user_password) {
        return userMapper.selectByLogin(user_name,user_password);
    }

    @Override
    public Integer getTotal(String user_name) {
        return userMapper.selectTotal(user_name);
    }
}