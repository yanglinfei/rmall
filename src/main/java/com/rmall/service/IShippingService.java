package com.rmall.service;

import com.github.pagehelper.PageInfo;
import com.rmall.commom.ServerResponse;
import com.rmall.pojo.Shipping;

/**
 * Created by ylf on 2017/11/15.
 */
public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse delete(Integer userId, Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
