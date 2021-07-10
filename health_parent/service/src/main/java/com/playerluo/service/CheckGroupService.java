package com.playerluo.service;

import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.health.pojo.CheckGroup;

/**
 * 新增检查组
 */
public interface CheckGroupService {
  int add(CheckGroup checkGroup ,int [] checkItemIds);

  PageResult<CheckGroup> findPage(QueryPageBean queryPageBean);
}
