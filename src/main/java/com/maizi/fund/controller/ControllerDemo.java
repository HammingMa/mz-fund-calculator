package com.maizi.fund.controller;

import com.maizi.fund.model.domain.Employee;
import com.maizi.fund.model.domain.ImpalaDemo;
import com.maizi.fund.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/11 11:02 上午
 */
@Controller
@RequestMapping("/test")
public class ControllerDemo {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @return index 页面
     */
    @RequestMapping("/index")
    public String getIndexPage() {
        return "hello";
    }


    /**
     *
     * @param map
     * @return 返回 employee 页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(ModelMap map) {
//        List<Employee> employeeList = employeeService.selectAll();
//
//        map.addAttribute("employeeList", employeeList);
//
//        for(Employee employee : employeeList) {
//            System.out.println(employee);
//        }


        List<ImpalaDemo> impalaDemos = employeeService.selectImpala();

        for (ImpalaDemo impalaDemo : impalaDemos) {
            System.out.println(impalaDemo);
        }
        return "index";
    }


    @PostMapping("/emp2")
    public String getAllEmployee(ModelMap map) {
        List<Employee> employeeList = employeeService.selectAll();

        map.addAttribute("employeeList", employeeList);

        for(Employee employee : employeeList) {
            System.out.println(employee);
        }
        return "employee";
    }


    @PostMapping("/emp2/search")
    public String getEmployeeById(ModelMap map,
                                  @RequestParam(name = "search_value", required = true) String searchValue) {
        List<Employee> employeeList = employeeService.selectById(searchValue);

        map.addAttribute("employeeList", employeeList);

        for(Employee employee : employeeList) {
            System.out.println(employee);
        }
        return "employee";
    }


    @GetMapping("/hello")
    public String getOneEmployee() {
        Employee employee = employeeService.selectOne();

        System.out.println(employee);

        return "hello";
    }


}
