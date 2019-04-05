/**
 * @Title: UserService.java
 * @Package com.wpf.eurekaclient.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:05:40
 * @version V1.0
 */
package com.wpf.eurekaclient.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpf.eurekaclient.entity.User;
import com.wpf.eurekaclient.mapper.UserMapper;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pengfei.wang
 * @date 2019年4月3日 下午5:05:40
 */
@Service
public class UserService {

  @Resource
  private UserMapper userMapper;

  public User login(String login, String password) {
    return userMapper.login(login, password);
  }

  public int register(User user) {
    return userMapper.insertSelective(user);
  }

  public User getUserByOpenId(String openId) {
    return userMapper.getUserByOpenId(openId);
  }

  public User verifyUser(String openId, int userId, String appId) {
    return userMapper.verifyUser(openId, userId, appId);
  }

  public User getUserByLoginAndApp(String login,String appId) {
    return userMapper.getUserByLogin(login,appId);
  }
}
