package com.playerluo.controller;

import com.playerluo.constant.MessageConstant;
import com.playerluo.entity.Result;
import com.playerluo.health.pojo.CheckGroup;
import com.playerluo.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckGroupController {
  @Autowired
  private CheckGroupService checkGroupService;

  /**
   * 新增检查组
   * 访问的地址  localhost:83/checkGroup
   *
   * @return
   */
  @PostMapping("/checkGroup/{checkitemIds}")
  public Result add(@RequestBody CheckGroup checkGroup, @PathVariable("checkitemIds") int[] checkitemIds) {
    int row = checkGroupService.add(checkGroup, checkitemIds);
    Result result = null;
    if (row > 0){
      result = new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }else {
      result = new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
    }
    return result;
  }
}
