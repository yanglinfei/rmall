package com.rmall.controller.backend;

import com.github.pagehelper.PageInfo;
import com.rmall.commom.Const;
import com.rmall.commom.ServerResponse;
import com.rmall.pojo.User;
import com.rmall.service.IOrderService;
import com.rmall.service.IUserService;
import com.rmall.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ylf on 2017/11/22.
 */
@Controller
@RequestMapping("/manage/order")
public class OrderManageController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录管理员账户");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iOrderService.manageList(pageNum, pageSize);
        } else  {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<OrderVo> orderList(HttpSession session, Long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录管理员账户");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iOrderService.manageDetail(orderNo);
        } else  {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse orderSearch(HttpSession session, Long orderNo, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录管理员账户");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iOrderService.manageSearch(orderNo,pageNum, pageSize);
        } else  {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("send_goods.do")
    @ResponseBody
    public ServerResponse<String> orderSendGoods(HttpSession session, Long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录管理员账户");
        }

        if (iUserService.checkAdminRole(user).isSeccess()) {
            return iOrderService.manageSendGoods(orderNo);
        } else  {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }
}
