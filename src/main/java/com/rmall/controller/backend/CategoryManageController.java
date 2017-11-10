package com.rmall.controller.backend;

import com.rmall.commom.Const;
import com.rmall.commom.ResponseCode;
import com.rmall.commom.ServerResponse;
import com.rmall.pojo.User;
import com.rmall.service.ICategoryService;
import com.rmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.Oneway;
import javax.servlet.http.HttpSession;

/**
 * Created by ylf on 2017/11/10.
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName,@RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iCategoryService.addCategory(categoryName, parentId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse setCateGoryname(HttpSession session,Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iCategoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session,@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iCategoryService.getChildrenParallelCategory(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }


    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategaryAndDeepChildrenCategary(HttpSession session,@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iCategoryService.selectCategaryAndChildrenById(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }
}
