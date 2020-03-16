package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.User;
import com.health.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Controller
@RequestMapping("/api")
public class UserController {

    public static final String SESSION_KEY = "LOGIN_USER";
    private static final String AUTO_LOGIN_KEY = "auto_login_taken";

    @Autowired
    private IUserService iUserService;

    //查询
    @RequestMapping(path = "/select",method = RequestMethod.GET)
    @ResponseBody
    public List<User> select(){
//        System.out.println("controller---");
        return iUserService.select();
    }




    //注册  以实现
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register( @RequestParam("userName")String userName ,
                          @RequestParam("password")String password,@RequestParam("phone")String phone){
        System.out.println(userName+password+phone);
        if(userName==null || password==null ||  phone==null){
            return new ServerResponse(250,"you need to add the param");
        }else {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setPhone(phone);
//            System.out.println(user);
            System.out.println("controller====");
            String message = iUserService.insert(user);
            //result  无法实现
            if(message.equals("该用户已经存在，请重新输入")){
                return new ServerResponse(250,"the account is already");
            }else if(message.equals("电话号码已存在，请重新输入")){
                return new ServerResponse(250,"the telephone is already");
            }
            return new ServerResponse(200,"success");
        }
    }


    //登录
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(@RequestParam("userName")String userName ,
                                @RequestParam("password")String password,
                                HttpSession session, HttpServletResponse response,
                                @RequestParam("autoLogin")boolean autoLogin){
        if(userName.length()==0 || userName==null || password==null || password.length()==0){
            return new ServerResponse(250,"you need to write all param");
        }
        String message = iUserService.login(userName,password,autoLogin);
        User user = iUserService.selectByName(userName);
        if(message.equals("用户名或者密码是错误的")){
            return new ServerResponse(250,"userName or password is not ok");
        }
        ServerResponse serverResponse=null;
        if(message.equals("登陆成功")){

            serverResponse= new ServerResponse(200,"load success",user);
            session.setAttribute(SESSION_KEY, serverResponse.getData());
            if (autoLogin) {
                //Cookie中写入自动登录凭证
                String taken = user.getTaken();
                Cookie cookie = new Cookie(AUTO_LOGIN_KEY, taken);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
            }
            return serverResponse;
        }
        return new ServerResponse(250,"happen predicting error");
    }

    @RequestMapping(value = "/login/auto", method = RequestMethod.POST)
    public @ResponseBody ServerResponse autoLogin(HttpServletRequest request, HttpSession session) {
        //获取Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return new ServerResponse(250,"no cookie");
        }
        //遍历查找凭证
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(AUTO_LOGIN_KEY)) {
                //调用Service方法自动登录
                //ServerResponse<User> autoLoginResult = null;
                String open= iUserService.autoLogin(cookie.getValue());
                if (open.equals("自动登录成功")) {
                    User user= iUserService.SelectTaken(cookie.getValue());
                    session.setAttribute(SESSION_KEY, user);
                    return new ServerResponse(200,"auto success load",user);
                }
            }
        }
        return  new ServerResponse(250,"no cookie");
    }






    //登出   已经实现
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public @ResponseBody ServerResponse logout(HttpSession session,HttpServletResponse response){
        if(session.getAttribute(SESSION_KEY)==null){
            return new ServerResponse(250,"no user is loading.." );
        }
        session.removeAttribute(SESSION_KEY);
        Cookie cookie = new Cookie(AUTO_LOGIN_KEY,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ServerResponse(200,"logout is success");
    }



}
