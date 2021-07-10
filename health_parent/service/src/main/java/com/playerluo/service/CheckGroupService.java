package com.playerluo.service;

import com.playerluo.health.pojo.CheckGroup;

/**
 * 新增检查组
 */
public interface CheckGroupService {
  int add(CheckGroup checkGroup ,int [] checkItemIds);
}
