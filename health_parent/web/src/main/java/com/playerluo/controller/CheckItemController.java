package com.playerluo.controller;

import com.playerluo.constant.MessageConstant;
import com.playerluo.entity.PageResult;
import com.playerluo.entity.QueryPageBean;
import com.playerluo.entity.Result;
import com.playerluo.health.pojo.CheckItem;
import com.playerluo.service.CheckItemService;
import com.playerluo.service.impl.CheckItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这是用来处理检查项的controller
 *  添加操作,传递过来的是JSON数据,如果用javabean接收需要用注解
 */
//这里不使用@Controller注解,因为这里所有的后台方法返回的都是json字符串,不会进行跳转
@RestController
@RequestMapping("/checkItem")
public class CheckItemController {
  //让spring注入进来
  @Autowired
  private CheckItemService checkItemService;

  @GetMapping("/Items")
  public Result findAll(){
    try {
      List<CheckItem> all = checkItemService.findAll();
      return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,all);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
    }
  }
  /**
   * 查询所有页面
   * @param queryPageBean
   * @return
   */
  @RequestMapping("/findPage")
  public Result findPage(@RequestBody QueryPageBean queryPageBean){
    Result result = null;
    try {
      //调用service
      PageResult<CheckItem> pageResult = checkItemService.findPage(queryPageBean);
      //给页面相应
      result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);
    } catch (Exception e) {
      e.printStackTrace();
      result = new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
    }
    return result;
  }

  /**
   * 新增检查项
   * @param checkItem
   * @return
   */
  @RequestMapping("/add")
  public Result add(@RequestBody CheckItem checkItem){
    //调用service
    int add = checkItemService.add(checkItem);
    //给页面返回数据
    Result result = null;
    if (add > 0){
      result = new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }else {
      result = new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
    }
    return result;
  }

  /**
   * 删除检查项
   * @param id
   * @return
   */
  @RequestMapping("/delete")
  public Result delete(int id){
    Result result = null;
    int row = checkItemService.delete(id);
    if (row > 0 ){
      result = new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }else {
      result = new Result(false,MessageConstant.DELETE_CHECKITEM_FAIL);
    }
    return result;
  }

  /**
   * 更新检查项
   * @param checkItem
   * @return
   */
  @RequestMapping("/upDate")
  public Result upDate(@RequestBody CheckItem checkItem){
    int row = checkItemService.upDate(checkItem);
    Result result = null;
    if (row > 0 ){
      result = new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }else {
      result = new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
    }
    return result;
  }
}
