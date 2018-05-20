//package com.loan;
//
//import com.loan.entity.*;
//import com.loan.service.*;
//import com.loan.util.DateUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.jws.Oneway;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ServiceTest {
//
//    @Autowired
//    private AnnouncementService announcementService;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private DepartmentService departmentService;
//
//    @Autowired
//    private MortgageCheckListService mortgageCheckListService;
//
//    @Autowired
//    private MortgageRecordService mortgageRecordService;
//
//    @Autowired
//    private MortgageApproveService mortgageApproveService;
//
//    @Autowired
//    private MortgageLoanConditionService mortgageLoanConditionService;
//
//    @Autowired
//    private BankService bankService;
//
//    @Autowired
//    private EvaluateCompanyService evaluateCompanyService;
//
//    @Test
//    public void evaluateCompanyServiceTest(){
//        EvaluateCompany evaluateCompany = new EvaluateCompany();
//        evaluateCompany.setId(UUID.randomUUID().toString().replace("-",""));
//        evaluateCompany.setName("评估公司一");
//        evaluateCompany.setAddress("武汉市洪山区八一路1号");
//        evaluateCompanyService.save(evaluateCompany);
//
//        EvaluateCompany evaluateCompany2 = new EvaluateCompany();
//        evaluateCompany2.setId(UUID.randomUUID().toString().replace("-",""));
//        evaluateCompany2.setName("评估公司二");
//        evaluateCompany2.setAddress("武汉市洪山区八一路2号");
//        evaluateCompanyService.save(evaluateCompany2);
//
//        EvaluateCompany evaluateCompany3 = new EvaluateCompany();
//        evaluateCompany3.setId(UUID.randomUUID().toString().replace("-",""));
//        evaluateCompany3.setName("评估公司三");
//        evaluateCompany3.setAddress("武汉市洪山区八一路3号");
//        evaluateCompanyService.save(evaluateCompany3);
//    }
//
//    @Test
//    public void bankServiceTest(){
////        Bank bank = new Bank();
////        bank.setId(UUID.randomUUID().toString().replace("-",""));
////        bank.setName("工商银行");
////        bank.setAddress("武汉市洪山区珞喻路3号");
////        bankService.save(bank);
//    }
//
//    @Test
//    public void mortgageLoanConditionServiceTest(){
//        //添加放款条件
////        MortgageLoanCondition mortgageLoanCondition = new MortgageLoanCondition();
////        mortgageLoanCondition.setId(UUID.randomUUID().toString().replace("-",""));
////        mortgageLoanCondition.setContent("见他项权证放款");
////        mortgageLoanCondition.setNeed_guarantee(false);
////        mortgageLoanConditionService.save(mortgageLoanCondition);
////
////        MortgageLoanCondition mortgageLoanCondition1 = new MortgageLoanCondition();
////        mortgageLoanCondition1.setId(UUID.randomUUID().toString().replace("-",""));
////        mortgageLoanCondition1.setContent("见担保函放款");
////        mortgageLoanCondition1.setNeed_guarantee(true);
////        mortgageLoanConditionService.save(mortgageLoanCondition1);
//
//        //添加审批结果表
////        MortgageApprove mortgageApprove = new MortgageApprove();
////        mortgageApprove.setId(UUID.randomUUID().toString().replace("-",""));
////        MortgageLoanCondition mortgageLoanCondition = mortgageLoanConditionService.findOneById("abf2727c653342ca9c7a2a9ec8660f04");
////        mortgageApprove.setLoan_condition(mortgageLoanCondition);
////        mortgageApproveService.save(mortgageApprove);
//
//        //删除审批表
//        mortgageApproveService.deleteById("0ad6c5bc541a4c1a93e399ec94d8ccde");
//    }
//
//    @Test
//    public void mortgageRecordServiceTest(){
//        //新建record
////        MortgageRecord mortgageRecord = new MortgageRecord();
////        mortgageRecord.setId(UUID.randomUUID().toString().replace("-",""));
////        mortgageRecordService.save(mortgageRecord);
//
//        MortgageRecord record = mortgageRecordService.findOneById("4b5e4cbdaca140f0a91ac52618ff3359");
//        System.out.println(record.getId());
//    }
//
//    @Test
//    public void mortgageCheckListServiceTest(){
//        //添加CheckList和Houses
////        MortgageCheckList mortgageCheckList = new MortgageCheckList();
////        mortgageCheckList.setId(UUID.randomUUID().toString().replace("-",""));
////        mortgageCheckList.setClient_name("Client Name One");
////
////        List<MortgageHouse> mortgageHouseList = new ArrayList<>();
////        MortgageHouse mortgageHouse1 = new MortgageHouse();
////        mortgageHouse1.setId(UUID.randomUUID().toString().replace("-",""));
////        mortgageHouse1.setArea("11");
////        MortgageHouse mortgageHouse2 = new MortgageHouse();
////        mortgageHouse2.setId(UUID.randomUUID().toString().replace("-",""));
////        mortgageHouse2.setArea("22");
////        mortgageHouseList.add(mortgageHouse1);
////        mortgageHouseList.add(mortgageHouse2);
////
////        mortgageCheckList.setMortgageHouses(mortgageHouseList);
////        mortgageCheckListService.save(mortgageCheckList);
//
//        //查询所有的CheckList
////        List<MortgageCheckList> mortgageCheckLists = mortgageCheckListService.findAll();
////        for(MortgageCheckList mortgageCheckList: mortgageCheckLists){
////            List<MortgageHouse> mortgageHouseList = mortgageCheckList.getMortgageHouses();
////             for (MortgageHouse m :mortgageHouseList) {
////                System.out.println("Area:" + m.getArea());
////            }
////        }
//
//        //更新CheckList的同时更新Houses，Houses能够更新
////        MortgageCheckList mortgageCheckList = mortgageCheckListService.findOneById("ca95a4b7400f49e19eca6165d9714708");
////        List<MortgageHouse> mortgageHouseList = mortgageCheckList.getMortgageHouses();
////        for (MortgageHouse m :mortgageHouseList) {
////            m.setArea("77");
////        }
////        mortgageCheckListService.save(mortgageCheckList);
//
//        //删除CheckList,可同时删除Houses内容(delete由JPA提供)
//        mortgageCheckListService.deleteOneById("c231e971702e49ae9a342ec4f335dc62");
//
//        //删除CheckList,不能同时删除Houses内容(delete自定义)
////        mortgageCheckListService.deleteById("c231e971702e49ae9a342ec4f335dc62");
//    }
//
//    @Test
//    public void employeeServiceTest(){
//        //更新雇员信息
//        Employee employee = employeeService.findOneByAccount("123456@qq.com");
//        if(employee!=null){
//            employee.setDepartment(departmentService.findOneById(1));
//            employeeService.save(employee);
//            System.out.println("Done");
//        }
//
//        //插入新的雇员
////        Employee newEmployee = new Employee();
////        newEmployee.setId(UUID.randomUUID().toString().replace("-",""));
////        newEmployee.setAccount("123456@qq.com");
////        newEmployee.setPassword("123456");
////        newEmployee.setName("TestOne");
////        newEmployee.setRole(3);
////        newEmployee = employeeService.save(newEmployee);
////        System.out.println("Done with " + newEmployee.getName());
//
//        //查询所有的雇员
////        List<Employee> employees = employeeService.findAll();
////        for (Employee employee: employees) {
////            System.out.println("Employee Name:"+ employee.getName());
////            System.out.println("Department Name:"+ employee.getDepartment().getName());
////        }
//    }
//
//    @Test
//    public void announcementServiceTest(){
//        //新增Announcement
////        Announcement announcement = new Announcement();
////        announcement.setTitle("title");
////        Date now = new Date(System.currentTimeMillis());
////        announcement.setRelease_time(now);
////        announcement.setContent("content");
////        announcement.setImage_url("jahsdfg");
////        announcement.setAttachment_url("ahmsdfgd");
////        System.out.println(announcement.getTitle());
////        try {
////            announcementService.save(announcement);
////        }catch (Exception e){
////            e.printStackTrace();
////        }
//
//        //查询单个Announcement
////        Announcement announcement = announcementService.findById(1);
////        System.out.println(announcement.getId() + "-" + announcement.getTitle());
//
//        //查询所有
//        List<Announcement> announcements = announcementService.findAll();
//        for (Announcement a: announcements) {
//            System.out.println(a.getId() + "-" + a.getTitle() + "-" + DateUtil.getDateString(a.getRelease_time()));
//        }
//    }
//}
