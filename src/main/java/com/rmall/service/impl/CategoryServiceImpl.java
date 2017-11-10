package com.rmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.rmall.commom.ServerResponse;
import com.rmall.dao.CategoryMapper;
import com.rmall.pojo.Category;
import com.rmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by ylf on 2017/11/10.
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if (parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加品类参数错误");
        }

        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);

        int insertCount = categoryMapper.insert(category);
        if (insertCount > 0) {
            return ServerResponse.createBySuccessMessage("添加品类成功");
        }

        return ServerResponse.createByErrorMessage("添加品类失败");
    }

    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {

        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("更新品类参数错误");
        }

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);

        int updateCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (updateCount > 0) {
            return  ServerResponse.createBySuccessMessage("更新品类名字成功");
        }

        return ServerResponse.createByErrorMessage("更新品类名字失败");
    }


    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParrentId(categoryId);
        if (CollectionUtils.isEmpty(categoryList)) {
            logger.info("未找到当前分类的子分类");
        }

        return ServerResponse.createBySuccess(categoryList);
    }

    public ServerResponse selectCategaryAndChildrenById(Integer categoryId) {
        Set<Category> categorySet = Sets.newHashSet();
        findChildrenCategory(categorySet, categoryId);

        List<Integer> categoryIdList = Lists.newArrayList();
        if (categoryId != null) {
            for (Category categoryItem : categorySet) {
                categoryIdList.add(categoryItem.getId());
            }
        }

        return ServerResponse.createBySuccess(categoryIdList);
    }

    private Set<Category> findChildrenCategory(Set<Category> categorySet, Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            categorySet.add(category);
        }

        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParrentId(categoryId);
        for (Category categoryItem : categoryList) {
            findChildrenCategory(categorySet, categoryItem.getId());
        }

        return categorySet;
    }
}
