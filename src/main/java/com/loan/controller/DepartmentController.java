package com.loan.controller;

import com.alibaba.fastjson.JSON;
import com.loan.entity.Department;
import com.loan.service.DepartmentService;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getDepartment/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public DataReturn<Department> getEmployee(@PathVariable("departmentId") int departmentId){
        Department department = departmentService.findOneById(departmentId);
        DataReturn<Department> result = null;
        if(department == null){
            result = new DataReturn<>(Constant.RESULT_ERROR, "部门不存在" , null);
            return result;
        }
        result = new DataReturn<>(Constant.RESULT_OK, "" , department);
        return result;
    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<Integer> updateDepartment(@RequestParam(value = "newDepartment", defaultValue = "") String newDepartment){
        Department department = JSON.parseObject(newDepartment, Department.class);
        department = departmentService.save(department);
        if(null == department){
            return new DataReturn<>(Constant.RESULT_ERROR, "更新部门信息失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "更新部门信息成功", department.getId());
    }

    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<Integer> saveDepartment(@RequestParam(value = "newDepartment", defaultValue = "") String newDepartment){
        Department department = JSON.parseObject(newDepartment, Department.class);
        department = departmentService.save(department);
        if(null == department){
            return new DataReturn<>(Constant.RESULT_ERROR, "创建新部门失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "创建新部门成功", department.getId());
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
    @ResponseBody
    public DataReturn<Integer> deleteDepartment(@RequestParam(value = "id", defaultValue = "") int id){
        int result = departmentService.deleteById(id);
        if(1 != result ){
            return new DataReturn<>(Constant.RESULT_ERROR, "删除部门失败", 0);
        }
        return new DataReturn<>(Constant.RESULT_OK, "删除部门成功", 1);
    }
}
