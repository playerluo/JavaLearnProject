package com.playerluo.service.impl;

import com.playerluo.dao.CheckItemDao;
import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.health.pojo.CheckItem;
import com.playerluo.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 这是检查项的Service层
 *  首先需要把这个类交给spring管理
 *  添加事务
 *  调用dao，让spring注入进来
 */
@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
  //让spring注入dao
  @Autowired
  private CheckItemDao dao;

  /**
   * 新增检查项
   * @param checkItem
   * @return
   */
  @Override
  public int add(CheckItem checkItem) {
    return dao.add(checkItem);
  }

  /**
   * 分页查询
   * @param queryPageBean 查询条件
   * @return
   */
  @Override
  public PageResult findPage(QueryPageBean queryPageBean) {
    System.out.println("queryPageBean = " + queryPageBean);
    long total = dao.findCount(queryPageBean);
    List<CheckItem> list = dao.findPage(queryPageBean);
    return new  PageResult<>(total, list);
  }
}
