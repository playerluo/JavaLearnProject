package com.playerluo.service.impl;

import com.playerluo.dao.CheckGroupDao;
import com.playerluo.health.pojo.CheckGroup;
import com.playerluo.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用于处理检查组业务
 */

@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
  //注入Dao
  @Autowired
  private CheckGroupDao checkGroupDao;

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
}
