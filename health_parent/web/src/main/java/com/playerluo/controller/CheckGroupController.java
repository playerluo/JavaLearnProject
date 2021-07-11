package com.playerluo.controller;

import com.playerluo.constant.MessageConstant;
import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.entity.Result;
import com.playerluo.health.pojo.CheckGroup;
import com.playerluo.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CheckGroupController {
  @Autowired
  private CheckGroupService checkGroupService;

  /**
   * 根据ID查询检查组中的检查项
   * @param groupId
   * @return
   */
  @GetMapping("/groupItems/{id}")
  public Result findItemsByGroupId(@PathVariable("id") int groupId){
    try {
      List<Integer> itemsByGroupId = checkGroupService.findItemsByGroupId(groupId);
      return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,itemsByGroupId);

    } catch (Exception e) {
      e.printStackTrace();
      return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
    }

  }

  /**
   * 新增检查组
   * 访问的地址  localhost:83/checkGroup
   *
   * @return
   */
  @PostMapping("/checkGroup/{id}")
  public Result add(@RequestBody CheckGroup checkGroup, @PathVariable("id") int[] checkItemIds) {
    int row = checkGroupService.add(checkGroup, checkItemIds);
    Result result = null;
    if (row > 0){
      result = new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }else {
      result = new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
    }
    return result;
  }

  /**
   * 检查组分页
   * @param queryPageBean
   * @return
   */
  @GetMapping("/checkgroup")
  public Result findPage(QueryPageBean queryPageBean){
    try {
      PageResult<CheckGroup> page = checkGroupService.findPage(queryPageBean);
      return new Result(true , MessageConstant.QUERY_CHECKGROUP_SUCCESS , page);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result(false , MessageConstant.QUERY_CHECKGROUP_FAIL);
    }
  }

  /**
   * 更新检查项
   * @param checkGroup
   * @param checkItemIds
   * @return
   */
  @PutMapping("/checkGroup/{id}")
  public Result update(@RequestBody CheckGroup checkGroup, @PathVariable("id") int[] checkItemIds){
    int row = checkGroupService.update(checkGroup, checkItemIds);
    Result result = null;
    if (row > 0){
      result = new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }else {
      result = new Result(false, MessageConstant.EDIT_CHECKGROUP_FAIL);
    }
    return result;
  }
}
