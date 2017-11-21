package com.rmall.service;

import com.rmall.commom.ServerResponse;

import java.util.Map;

/**
 * Created by ylf on 2017/11/20.
 */
public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse<Boolean> queryOrderPayStatus(Integer userId, Long orderNo);
}
