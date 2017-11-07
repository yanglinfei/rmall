package com.rmall.controller.portal;
import com.rmall.commom.Const;
import com.rmall.commom.ServerResponse;
import com.rmall.pojo.User;
import com.rmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ylf on 2017/11/6.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        //Service->mybatis->dao
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSeccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }

        return response;
    }

}
