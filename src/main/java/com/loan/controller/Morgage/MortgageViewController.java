package com.loan.controller.Morgage;

import com.alibaba.fastjson.JSON;
import com.loan.entity.MortgageAdvice;
import com.loan.entity.MortgageRecord;
import com.loan.service.MortgageAdviceService;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(value = "抵押贷款面谈模块", tags = "抵押贷款面谈模块")
@RestController
@RequestMapping("/view")
public class MortgageViewController {

    @Autowired
    private MortgageAdviceService mortgageAdviceService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @ApiOperation(value = "查看面谈建议表", notes = "查看面谈建议表")
    @ResponseBody
    @RequestMapping(value = "/{adviceId}", method = RequestMethod.GET)
    public DataReturn<MortgageAdvice> getAdvice(@PathVariable("adviceId") String adviceId){
        if(null == adviceId || "".equals(adviceId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "面谈建议表ID不合法" , null);
        }
        MortgageAdvice mortgageAdvice = mortgageAdviceService.findOneById(adviceId);
        if(mortgageAdvice == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "面谈建议表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageAdvice);
    }

    @ApiOperation(value = "添加面谈建议表", notes = "添加面谈建议表")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveAdvice(@RequestParam(value = "advice", defaultValue = "") String advice,
                                         @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                         @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(advice) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            //添面谈建议表
            MortgageAdvice mortgageAdvice = JSON.parseObject(advice, MortgageAdvice.class);
            mortgageAdvice.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageAdvice = mortgageAdviceService.save(mortgageAdvice);
            if(null == mortgageAdvice){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加面谈建议表失败", "");
            }
            //设置record
            mortgageRecord.setAdvice(mortgageAdvice.getId());
            mortgageRecord.setAdvice_operator(employeeId);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
            //view task完成
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加面谈建议表失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加面谈建议表成功", mortgageRecord.getId());
    }

    @ApiOperation(value = "废除订单", notes = "废除订单")
    @ResponseBody
    @RequestMapping(value = "/suspend", method = RequestMethod.POST)
    public DataReturn<String> suspendRecord(@RequestParam(value = "time", defaultValue = "") String time,
                                            @RequestParam(value = "taskId", defaultValue = "") String taskId,
                                            @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(time) || "".equals(taskId) || "".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入参数不合法" , null);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date finishTime = null;
        try {
            finishTime = sdf.parse(time);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入时间格式有误", "");
        }
        MortgageRecord mortgageRecord = mortgageRecordService.findOneById(taskService.getVariable(taskId, Constant.LOANID).toString());
        if(null == mortgageRecord){
            return new DataReturn<>(Constant.RESULT_ERROR, "贷款记录不存在", "");
        }
        try {
            runtimeService.deleteProcessInstance(mortgageRecord.getProcess_id(),"View");
            mortgageRecord.setRecord_state(Constant.LOANRECORD_ABANDON);
            mortgageRecord.setAdvice_operator(employeeId);
            mortgageRecord.setAbandon_time(finishTime);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "废单失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "废单成功", mortgageRecord.getId());
    }
}
