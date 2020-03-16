package com.health.service.impl;

import com.health.common.ServerResponse;
import com.health.entity.User;
import com.health.mapper.UserMapper;
import com.health.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String insert(User user) {
        List<User> list = userMapper.select();
        for(int i =0;i<list.size();i++){
            if(user.getUserName().equals(list.get(i).getUserName())){
                return "该用户已经存在，请重新输入";
            }else if(user.getPhone().equals(list.get(i).getPhone())){
                return "电话号码已存在，请重新输入";
            }
        }
        userMapper.insert(user);
        return "注册成功";
    }

    @Override
    public List<User> select() {
        System.out.println("service--");
        return userMapper.select();
    }

    @Override
    public String login(String userName, String password, boolean autoLogin) {
        if(userName==null || userName.length()==0 || password.length()==0 || password==null){
            return "you need to write all param";
        }
        User user = userMapper.selectByName(userName);
        if(user!=null && password.equals(user.getPassword())){
            if(autoLogin){
                user.setTaken(registerAutoLogin(user).getData());
            }
            return "登陆成功";
        }
        return "用户名或者密码是错误的";
    }

    @Override
    public User selectByName(String userName) {
        return userMapper.selectByName(userName);
    }

    @Override
    public String autoLogin(String taken) {
        //查询数据库并判断登录
        User user = userMapper.autoLogin(taken);
        if (user != null) {
            return ( "自动登录成功");
        }
        return ("登录失败");
    }

    @Override
    public ServerResponse<String> registerAutoLogin(User user) {
        //System.out.println("222222");
        //构建凭证元数据
        String source = user.getUserName() + user.hashCode() + System.currentTimeMillis();
        // System.out.println("222222");
        //编译自动登录凭证
        String taken = BCrypt.hashpw(source, BCrypt.gensalt());
        //System.out.println("222222");
        //将自动登录凭证写入数据库
        try {
            userMapper.registerAutoLogin(user.getUserName(), taken);
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("222222");
        return new ServerResponse(taken);
    }

    @Override
    public User SelectTaken(String taken) {
        return userMapper.autoLogin(taken);
    }


}
