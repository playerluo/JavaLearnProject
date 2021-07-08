package com.playerluo.service;

import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.health.pojo.CheckItem;

public interface CheckItemService {
  /**
   * 添加检查项
   * @param checkItem
   * @return 影响的行数
   */
  int add(CheckItem checkItem);

  /**
   * 分页查询
   * @param queryPageBean 查询条件
   * @return  PageResult
   */
  PageResult<CheckItem> findPage(QueryPageBean queryPageBean);
}
