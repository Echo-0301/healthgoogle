package com.health.service;

import com.health.common.ServerResponse;
import com.health.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IUserService {

    String insert(User user);

    List<User> select();

    String login(String userName, String password, boolean autoLogin);

    User selectByName(String userName);

    public String autoLogin(String taken);

//    @Override
    public ServerResponse<String> registerAutoLogin(User user) ;

    public User SelectTaken(String taken);
}
