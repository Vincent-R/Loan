package com.loan.controller.Manage;

import com.alibaba.fastjson.JSON;
import com.loan.entity.Department;
import com.loan.model.DepartmentModel;
import com.loan.service.DepartmentService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "部门管理模块",tags = "部门管理模块")
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "通过部门id查询部门信息")
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Department> getEmployee(@PathVariable("departmentId") String departmentId){
        if("".equals(departmentId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "部门ID不合法" , null);
        }
        Department department = departmentService.findOneById(departmentId);
        if(department == null){
            return new DataReturn<>(Constant.RESULT_ERROR, "部门不存在" , null);
        }
        return new DataReturn<>(Constant.RESULT_OK, "" , department);
    }

    @ApiOperation(value = "更新部门信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> updateDepartment(@RequestParam(value = "newDepartment", defaultValue = "") String newDepartment){
        if("".equals(newDepartment)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入部门不合法" , null);
        }
        Department department = JSON.parseObject(newDepartment, Department.class);
        department = departmentService.save(department);
        if(null == department){
            return new DataReturn<>(Constant.RESULT_ERROR, "更新部门信息失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "更新部门信息成功", department.getId());
    }
    @ApiOperation(value = "创建部门")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<String> saveDepartment(@RequestParam(value = "newDepartment", defaultValue = "") String newDepartment){
        if("".equals(newDepartment)){
            return new DataReturn<>(Constant.RESULT_ERROR, "输入部门不合法" , null);
        }
        Department department = JSON.parseObject(newDepartment, Department.class);
        department = departmentService.save(department);
        if(null == department){
            return new DataReturn<>(Constant.RESULT_ERROR, "创建新部门失败", "");
        }
        return new DataReturn<>(Constant.RESULT_OK, "创建新部门成功", department.getId());
    }
    @ApiOperation(value = "通过部门id删除部门")
    @RequestMapping(value = "/delete/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Integer> deleteDepartment(@PathVariable("departmentId") String departmentId){
        if("".equals(departmentId)){
            return new DataReturn<>(Constant.RESULT_ERROR, "部门ID不合法" , null);
        }
        int result = departmentService.deleteById(departmentId);
        if(1 != result ){
            return new DataReturn<>(Constant.RESULT_ERROR, "删除部门失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "删除部门成功", 1);
    }

    @ApiOperation(value = "获取所有的部门信息")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<Department>> getAllDepartment(){
        return new DataReturn<>(Constant.RESULT_OK, "", departmentService.findAll());
    }

    @ApiOperation(value = "获取所有的部门Model信息")
    @RequestMapping(value = "/allModel", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<List<DepartmentModel>> getAllDepartmentModel(){
        return new DataReturn<>(Constant.RESULT_OK, "", departmentService.findAllIdName());
    }
}
