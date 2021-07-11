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

  /**
   * 根据ID查询检查组中的检查项
   * @param groupId
   * @return
   */
  List<Integer> findItemsByGroupId(int groupId);

  /**
   * 更新检查组信息
   * @param checkGroup
   * @return
   */
  int update(CheckGroup checkGroup);

  /**
   * 根据ID删除检查组&检查项中间表数据
   * @param groupId
   * @return
   */
  int deleteByGroupId(int groupId);

  /**
   * 根据ID添加检查组&检查项中间表数据
   * @param groupId
   * @param checkItemIds
   * @return
   */
  int addByGroupId(@Param("groupId") int groupId, @Param("checkItemIds") int checkItemIds);
}
