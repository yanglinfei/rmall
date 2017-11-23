package com.rmall.service;

import com.github.pagehelper.PageInfo;
import com.rmall.commom.ServerResponse;
import com.rmall.vo.OrderVo;

import java.util.Map;

/**
 * Created by ylf on 2017/11/20.
 */
public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse<Boolean> queryOrderPayStatus(Integer userId, Long orderNo);

    ServerResponse<OrderVo> createOrder(Integer userId, Integer shippingId);

    ServerResponse<String> cancel (Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    //backend
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);
}
