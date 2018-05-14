package com.loan;

import com.loan.entity.*;
import com.loan.service.*;
import com.loan.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MortgageCheckListService mortgageCheckListService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private MortgageRecordService mortgageRecordService;

    @Test
    public void mortgageRecordServiceTest(){
        //新建record
//        MortgageRecord mortgageRecord = new MortgageRecord();
//        mortgageRecord.setId(UUID.randomUUID().toString().replace("-",""));
//        mortgageRecordService.save(mortgageRecord);

        MortgageRecord record = mortgageRecordService.findOneById("4b5e4cbdaca140f0a91ac52618ff3359");
        System.out.println(record.getId());
    }

    @Test
    public void mortgageCheckListServiceTest(){
        //添加CheckList和Houses
//        MortgageCheckList mortgageCheckList = new MortgageCheckList();
//        mortgageCheckList.setId(UUID.randomUUID().toString().replace("-",""));
//        mortgageCheckList.setClient_name("Client Name One");
//
//        List<MortgageHouse> mortgageHouseList = new ArrayList<>();
//        MortgageHouse mortgageHouse1 = new MortgageHouse();
//        mortgageHouse1.setId(UUID.randomUUID().toString().replace("-",""));
//        mortgageHouse1.setArea("11");
//        MortgageHouse mortgageHouse2 = new MortgageHouse();
//        mortgageHouse2.setId(UUID.randomUUID().toString().replace("-",""));
//        mortgageHouse2.setArea("22");
//        mortgageHouseList.add(mortgageHouse1);
//        mortgageHouseList.add(mortgageHouse2);
//
//        mortgageCheckList.setMortgageHouses(mortgageHouseList);
//        mortgageCheckListService.save(mortgageCheckList);

        //查询所有的CheckList
//        List<MortgageCheckList> mortgageCheckLists = mortgageCheckListService.findAll();
//        for(MortgageCheckList mortgageCheckList: mortgageCheckLists){
//            List<MortgageHouse> mortgageHouseList = mortgageCheckList.getMortgageHouses();
//             for (MortgageHouse m :mortgageHouseList) {
//                System.out.println("Area:" + m.getArea());
//            }
//        }

        //更新CheckList的同时更新Houses，Houses能够更新
//        MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById("ca95a4b7400f49e19eca6165d9714708");
//        List<MortgageHouse> mortgageHouseList = mortgageCheckList.getMortgageHouses();
//        for (MortgageHouse m :mortgageHouseList) {
//            m.setArea("77");
//        }
//        mortgageCheckListService.save(mortgageCheckList);

        //删除CheckList,可同时删除Houses内容(delete由JPA提供)
//        mortgageCheckListService.deleteOneById("ca95a4b7400f49e19eca6165d9714708");

        //删除CheckList,不能同时删除Houses内容(delete自定义)
        mortgageCheckListService.deleteById("c231e971702e49ae9a342ec4f335dc62");
    }

    @Test
    public void employeeServiceTest(){
        //更新雇员信息
        Employee employee = employeeService.findOneByAccount("123456@qq.com");
        if(employee!=null){
            employee.setDepartment(departmentService.findOneById(1));
            employeeService.save(employee);
            System.out.println("Done");
        }

        //插入新的雇员
//        Employee newEmployee = new Employee();
//        newEmployee.setId(UUID.randomUUID().toString().replace("-",""));
//        newEmployee.setAccount("123456@qq.com");
//        newEmployee.setPassword("123456");
//        newEmployee.setName("TestOne");
//        newEmployee.setRole(3);
//        newEmployee = employeeService.save(newEmployee);
//        System.out.println("Done with " + newEmployee.getName());

        //查询所有的雇员
//        List<Employee> employees = employeeService.findAll();
//        for (Employee employee: employees) {
//            System.out.println("Employee Name:"+ employee.getName());
//            System.out.println("Department Name:"+ employee.getDepartment().getName());
//        }
    }

    @Test
    public void announcementServiceTest(){
        //新增Announcement
//        Announcement announcement = new Announcement();
//        announcement.setTitle("title");
//        Date now = new Date(System.currentTimeMillis());
//        announcement.setRelease_time(now);
//        announcement.setContent("content");
//        announcement.setImage_url("jahsdfg");
//        announcement.setAttachment_url("ahmsdfgd");
//        System.out.println(announcement.getTitle());
//        try {
//            announcementService.save(announcement);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        //查询单个Announcement
//        Announcement announcement = announcementService.findById(1);
//        System.out.println(announcement.getId() + "-" + announcement.getTitle());

        //查询所有
        List<Announcement> announcements = announcementService.findAll();
        for (Announcement a: announcements) {
            System.out.println(a.getId() + "-" + a.getTitle() + "-" + DateUtil.getDateString(a.getRelease_time()));
        }
    }
}
