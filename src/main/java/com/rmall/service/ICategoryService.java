package com.rmall.service;

import com.rmall.commom.ServerResponse;
import com.rmall.pojo.Category;

import java.util.List;

/**
 * Created by ylf on 2017/11/10.
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse selectCategaryAndChildrenById(Integer categoryId);
}
