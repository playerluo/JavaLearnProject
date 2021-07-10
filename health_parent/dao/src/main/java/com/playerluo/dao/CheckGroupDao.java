package com.playerluo.dao;

import com.github.pagehelper.Page;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.health.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupDao {
  /**
   * 添加检查组
   * @param checkGroup
   * @return
   */
  int add(CheckGroup checkGroup);

  /**
   *  添加检查组和检查项
   * @param groupId
   * @param itemId
   * @return
   */
  int addCheckGroupItems(@Param("groupId") int groupId,@Param("itemId") int itemId);

  /**
   * 分页查询检查组
   * @param queryPageBean
   * @return
   */
  Page<CheckGroup> findPage(QueryPageBean queryPageBean);
}
