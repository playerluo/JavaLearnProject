package com.playerluo.dao;

import com.playerluo.health.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

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
}
