package com.wpf.eurekaclient.mapper;

import com.wpf.eurekaclient.entity.User;

public interface UserMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  User login(String login, String password);

  User getUserByOpenId(String openId);

  User verifyUser(String openId, int userId, String appId);

  User getUserByLogin(String login, String appId);
}