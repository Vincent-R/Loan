package com.loan.controller.Morgage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.loan.entity.MortgageCheckList;
import com.loan.entity.MortgageHouse;
import com.loan.entity.MortgageRecord;
import com.loan.service.ActivitiService;
import com.loan.service.MortgageCheckListService;
import com.loan.service.MortgageHouseService;
import com.loan.service.MortgageRecordService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Api(value = "抵押贷款接单模块")
@RestController
@RequestMapping("/checklist")
public class MortgageCheckListController {

    @Autowired
    private MortgageCheckListService mortgageCheckListService;

    @Autowired
    private ActivitiService activitiService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @ApiOperation(value = "查询客户交接表")
    @ResponseBody
    @RequestMapping(value = "/{checklistId}", method = RequestMethod.GET)
    public DataReturn<MortgageCheckList> getCheckList(@PathVariable("checklistId") String checklistId){
        if(null==checklistId || "".equals(checklistId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "客户交接表ID不合法" , null);
        }
        MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById(checklistId);
        if(mortgageCheckList == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "客户交接表不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , mortgageCheckList);
    }

    @ApiOperation(value = "创建客户交接表")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DataReturn<String> saveCheckList(@RequestParam(value = "checklist", defaultValue = "") String checklist,
                                            @RequestParam(value = "employeeId", defaultValue = "") String employeeId){
        if("".equals(checklist)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入客户交接表不合法" , null);
        }
        if("".equals(employeeId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入的业务员ID不合法" , null);
        }
        MortgageRecord mortgageRecord = new MortgageRecord();//新建抵押贷款单子
        try {
            //添加客户交接表
            MortgageCheckList mortgageCheckList = JSON.parseObject(checklist, MortgageCheckList.class);
            mortgageCheckList.setId(UUID.randomUUID().toString().replace("-",""));
            //添加房产信息
            List<MortgageHouse> mortgageHouses = mortgageCheckList.getMortgageHouses();//JSONArray.parseArray(houses, MortgageHouse.class);
            for (MortgageHouse house: mortgageHouses) {
                house.setId(UUID.randomUUID().toString().replace("-",""));
                house.setChecklist_id(mortgageCheckList.getId());
            }
            mortgageCheckList = mortgageCheckListService.save(mortgageCheckList);
            if(null == mortgageCheckList){
                return new DataReturn<>(Constant.RESULT_ERROR, "客户交接失败", "");
            }
            mortgageRecord.setId(UUID.randomUUID().toString().replace("-",""));
            mortgageRecord.setChecklist(mortgageCheckList.getId());
            mortgageRecord.setChecklist_operator(employeeId);
            //启动新的流程
            Map<String, Object> variableMap = new HashMap<>();
            variableMap.put("loanId", mortgageRecord.getId());
            mortgageRecord.setProcess_id(activitiService.startProcessInstance("mortgageLoan", variableMap));
            mortgageRecord = mortgageRecordService.save(mortgageRecord);
            if(null == mortgageRecord){
                return new DataReturn<>(Constant.RESULT_ERROR, "添加贷款记录失败", "");
            }
        }catch (Exception e){
            return new DataReturn<>(Constant.RESULT_ERROR, "客户交接失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "客户交接成功", mortgageRecord.getId());
    }
}
