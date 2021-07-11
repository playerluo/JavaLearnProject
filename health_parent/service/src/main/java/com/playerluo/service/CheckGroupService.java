package com.playerluo.service;

import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.entity.Result;
import com.playerluo.health.pojo.CheckGroup;

import java.util.List;

/**
 * 检查组
 */
public interface CheckGroupService {
  /**
   * 新增检查组
   * @param checkGroup
   * @param checkItemIds
   * @return
   */
  int add(CheckGroup checkGroup ,int [] checkItemIds);

  /**
   * 检查组分页
   * @param queryPageBean
   * @return
   */
  PageResult<CheckGroup> findPage(QueryPageBean queryPageBean);


  List<Integer> findItemsByGroupId(int groupId);

  int update(CheckGroup checkGroup, int[] checkItemIds);
}
