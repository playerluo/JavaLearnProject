package com.playerluo.dao;

import com.playerluo.entity.QueryPageBean;
import com.playerluo.health.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
  /**
   * 添加检查项,返回影响的行数
   * @return
   */
  int add(CheckItem checkItem);

  /**
   * 查询表的总记录数,由于可能会有附带的查询条件
   * @param queryPageBean
   * @return
   */
  long findCount(QueryPageBean queryPageBean);

  /**
   * 查询当前页的集合数据
   * @param queryPageBean
   * @return
   */
  List<CheckItem> findPage(QueryPageBean queryPageBean);

  /**
   * 根据检查项id查询是否被检查组使用
   * @param id
   * @return 被检查组使用的总数
   */
  long findById(int id);

  /**
   * 根据Id删除检查项
   * @param id
   * @return
   */
  int deleteById(int id);

  int upDate(CheckItem checkItem);
}

