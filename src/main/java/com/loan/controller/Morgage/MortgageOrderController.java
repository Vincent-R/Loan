package com.loan.controller.Morgage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.loan.entity.MortgageForm;
import com.loan.entity.MortgageRecord;
import com.loan.entity.MortgageReport;
import com.loan.service.MortgageFormService;
import com.loan.service.MortgageRecordService;
import com.loan.service.MortgageReportService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api(value = "抵押贷款评估下单模块", tags = "抵押贷款评估下单模块")
@RestController
@RequestMapping("/order")
public class MortgageOrderController {

    @Autowired
    private MortgageReportService mortgageReportService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Autowired
    private TaskService taskService;

    @ApiOperation(value = "确定下单状态", notes = "确定下单状态")
    @ResponseBody
    @RequestMapping(value = "/state/save", method = RequestMethod.POST)
    public DataReturn<String> saveOrderState(@RequestParam(value = "time", defaultValue = "") String time,
                                             @RequestParam(value = "company", defaultValue = "") String company,
                                             @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(time) || "".equals(company) || "".equals(taskId)){
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
            //修改贷款记录
            mortgageRecord.setOrder_finish_time(finishTime);
            mortgageRecord.setOrder_evaluate_company(company);
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "确定下单状态失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "确定下单状态失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "确定下单状态成功", mortgageRecord.getId());
    }

    @ApiOperation(value = "添加报告", notes = "添加报告")
    @ResponseBody
    @RequestMapping(value = "/report/save", method = RequestMethod.POST)
    public DataReturn<String> saveReport(@RequestParam(value = "time", defaultValue = "") String time,
                                         @RequestParam(value = "type") int type,
                                         @RequestParam(value = "reports", defaultValue = "") String reports,
                                         @RequestParam(value = "taskId", defaultValue = "") String taskId){
        if("".equals(time) || "".equals(reports) || "".equals(taskId)){
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
        if(null == mortgageRecord.getOrder_finish_time() || "".equals(mortgageRecord.getOrder_finish_time())){
            return new DataReturn<>(Constant.RESULT_ERROR, "请先确定下单状态", "");
        }
        try {
            List<MortgageReport> mortgageReports = JSONArray.parseArray(reports, MortgageReport.class);
            for (MortgageReport mortgageReport: mortgageReports) {
                mortgageReport.setId(UUID.randomUUID().toString().replace("-",""));
                mortgageReport.setReport_type(type);
                mortgageReport.setLoan_id(mortgageRecord.getId());
            }
            mortgageReports = mortgageReportService.saveAll(mortgageReports);
            if(null == mortgageReports){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
            }
            //修改贷款记录
            mortgageRecord.setOrder_report_finish_time(finishTime);
            if(Constant.ORDER_REPORT_TYPE_ZHENGPING == type){
                mortgageRecord.setApprove_zp_finish_time(finishTime);
            }
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "修改贷款记录信息失败", "");
            }
            //order task完成
            taskService.complete(taskId);
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "添加报告失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "添加报告成功", mortgageRecord.getId());
    }
}
