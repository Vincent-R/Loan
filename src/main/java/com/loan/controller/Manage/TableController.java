package com.loan.controller.Manage;

import com.loan.entity.LoanCondition;
import com.loan.entity.LoanTableValue;
import com.loan.service.TableValueService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import com.loan.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Angel on 2018/8/29.
 */
@Api(value = "表单字段管理", tags = "表单字段管理")
@RestController
@RequestMapping(value = "/tableValue")
public class TableController {

    private static Logger log = LoggerFactory.getLogger(TableController.class);

    @Autowired
    private TableValueService tableValueService;


    /**
     * 根据值的ID类型查找值
     * @param id
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation(value = "根据值的ID类型查找值", notes = "根据值的ID类型查找值")
    @RequestMapping(value = "/{id}", name = "值的id", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<LoanTableValue> getLoanTableValue(@PathVariable("id") Integer id) throws Exception{
        if("".equals(id)){
            return new DataReturn<>(Constant.RESULT_ERROR, "ID不合法" , null);
        }
       LoanTableValue loanTableValue = tableValueService.findOneById(id);
        if(loanTableValue == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "账户不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , loanTableValue);

    }

    /**
     * 根据类型查找所有值
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation(value = "根据类型获取所有值信息", notes = "valueType 0-抵押贷款-面签-面签地点\n" +
            "1-抵押贷款-评估下单-评估公司\n" +
            "2-抵押贷款-审批-放款条件\n" +
            "3-二手房贷款-面签-面签地点\n" +
            "4-二手房贷款-评估下单-评估公司")
    @RequestMapping(value = "/value/{valueType}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<LoanTableValue>> getValueByType(@PathVariable("valueType") Integer valueType) throws Exception{
        if("".equals(valueType)){
            return new DataReturn<>(Constant.RESULT_ERROR, "表单类型不符合" , null);
        }
        List<LoanTableValue> list = tableValueService.findValueByType(valueType);
        if(list == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "查不到值" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "获取信息成功" , list);

    }


    /**
     * 查找所有值
     * @return
     */

    @Transactional(rollbackFor=Exception.class)
    @ApiOperation(value = "获取所有值信息",notes = "valueType 0-抵押贷款-面签-面签地点\n" +
            "1-抵押贷款-评估下单-评估公司\n" +
            "2-抵押贷款-审批-放款条件\n" +
            "3-二手房贷款-面签-面签地点\n" +
            "4-二手房贷款-评估下单-评估公司")
    @RequestMapping(value = "/allValue", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<String[][]> getAllValue(){
        return new DataReturn<>(Constant.RESULT_OK, "获取信息成功" , tableValueService.findAll());
    }

    /**
     * 添加值
     * @param valueType
     * @param value
     * @return
     */
    @ApiOperation(value = "设置值", notes = "valueType 0-抵押贷款-面签-面签地点\n" +
            "1-抵押贷款-评估下单-评估公司\n" +
            "2-抵押贷款-审批-放款条件\n" +
            "3-二手房贷款-面签-面签地点\n" +
            "4-二手房贷款-评估下单-评估公司")
    @RequestMapping(value = "/save/{valueType}/{value}/{remark}", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> saveValue(@PathVariable("valueType") Integer valueType, @PathVariable("value") String value, @PathVariable("remark") String remark) throws Exception{
        if("".equals(valueType) || "".equals(value) || "".equals(remark)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入不能为空" , null);
        }
        LoanTableValue loanTableValue = new LoanTableValue();
        loanTableValue.setValueType(valueType);
        loanTableValue.setValue(value);
        loanTableValue.setRemark(remark);
        Integer result = tableValueService.insert(loanTableValue);
        if(null == result){
            return new DataReturn<>(Constant.RESULT_ERROR, "设置失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "创建新用户成功", loanTableValue.toString());
    }

    /**
     * 修改值
     * @param id
     * @param valueType
     * @param value
     * @return
     */
    @ApiOperation(value = "修改值",notes = "valueType 0-抵押贷款-面签-面签地点\n" +
            "1-抵押贷款-评估下单-评估公司\n" +
            "2-抵押贷款-审批-放款条件\n" +
            "3-二手房贷款-面签-面签地点\n" +
            "4-二手房贷款-评估下单-评估公司")
    @RequestMapping(value = "/update/{id}/{valueType}/{value}", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> updateEmployee(@PathVariable(value = "id") Integer id,
                                             @PathVariable(value = "valueType") Integer valueType,
                                             @PathVariable(value = "value") String value) throws Exception{
        if("".equals(id) || "".equals(valueType) || "".equals(value)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入不能为空" , null);
        }
        LoanTableValue loanTableValue = new LoanTableValue();
        try {
            loanTableValue = tableValueService.findOneById(id);
        } catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "修改失败，您要修改的值的ID不存在", e.toString());
        }

        if(loanTableValue == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "修改失败，您要修改的值的ID不存在", null);
        }
        loanTableValue.setValueType(valueType);
        loanTableValue.setValue(value);
        Integer result  = tableValueService.updateById(loanTableValue);
        if(null == result){
            return new DataReturn<>(Constant.RESULT_ERROR, "修改失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "修改成功", loanTableValue.toString());
    }

    /**
     * 根据id删除值
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id删除值",notes = "valueType 0-抵押贷款-面签-面签地点\n" +
            "1-抵押贷款-评估下单-评估公司\n" +
            "2-抵押贷款-审批-放款条件\n" +
            "3-二手房贷款-面签-面签地点\n" +
            "4-二手房贷款-评估下单-评估公司")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Integer> deleteEmployee(@PathVariable("id") Integer id){
        if("".equals(id)){
            return new DataReturn<>(Constant.RESULT_ERROR, "您所删除的值ID不合法" , null);
        }
        int result = tableValueService.deleteById(id);
        if(1 != result ){
            return new DataReturn<>(Constant.RESULT_ERROR, "删除失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "删除成功", 1);
    }

    /**
     * 根据键来拿静态索引
     */
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation(value = "根据key来拿数据")
    @RequestMapping(value = "/value/{key}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn< Map<String, List<LoanTableValue>>> getIndexByKey(@RequestParam("key") String key) throws Exception{
        if("".equals(key)){
            return new DataReturn<>(Constant.RESULT_ERROR, "key不能为空" , null);
        }
        List<LoanTableValue> loanTableValues  = tableValueService.findValueByRemark(key);
        Map<String, List<LoanTableValue>> resultmap = new HashMap<String, List<LoanTableValue>>();
        resultmap.put(key, loanTableValues);

        return new DataReturn<>(Constant.RESULT_OK, "获取"+ key +"成功" , resultmap);
    }

}
