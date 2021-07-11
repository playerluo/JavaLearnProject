package com.playerluo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.playerluo.dao.CheckGroupDao;
import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.health.pojo.CheckGroup;
import com.playerluo.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用于处理检查组业务
 */

@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
  //注入Dao
  @Autowired
  private CheckGroupDao checkGroupDao;

  /**
   * 新增检查组
   * @param checkGroup
   * @param checkItemIds
   * @return
   */
  @Override
  public int add(CheckGroup checkGroup, int[] checkItemIds) {
    int row = checkGroupDao.add(checkGroup);
    int row2 = 0;
    if (row > 0 && checkItemIds.length > 0){
      for (int checkItemId : checkItemIds) {
        row2 += checkGroupDao.addCheckGroupItems(checkGroup.getId(),checkItemId);
      }
    }
    return row > 0 && row2 == checkItemIds.length ? 1 : 0;
  }

  /**
   * 检查组的分页效果
   * 使用分页插件完成
   * @param queryPageBean
   * @return
   */
  @Override
  public PageResult<CheckGroup> findPage(QueryPageBean queryPageBean) {
    //查询第几页，每页多少条
    PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
    Page<CheckGroup> page = checkGroupDao.findPage(queryPageBean);
    return new PageResult<>(page.getTotal(),page.getResult());
  }


  /**
   * 根据ID查询检查组中的检查项
   * @param groupId
   * @return
   */
  @Override
  public List<Integer> findItemsByGroupId(int groupId) {
    return checkGroupDao.findItemsByGroupId(groupId);
  }

  /**
   * 编辑检查组
   * @param checkGroup
   * @param checkItemIds
   * @return
   */
  @Override
  public int update(CheckGroup checkGroup, int[] checkItemIds) {
    int row = checkGroupDao.update(checkGroup);
    checkGroupDao.deleteByGroupId(checkGroup.getId());
    int row2 = 0;
    if (checkItemIds != null && checkItemIds.length > 0){
      for (int checkItemId : checkItemIds) {
        row2 += checkGroupDao.addByGroupId(checkGroup.getId(), checkItemId);
      }
    }
    return row > 0 && row2 == checkItemIds.length ? 1 : 0;
  }


}
