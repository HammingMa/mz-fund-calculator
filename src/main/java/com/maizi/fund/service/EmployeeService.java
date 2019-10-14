package com.maizi.fund.service;

import com.maizi.fund.model.domain.Employee;
import com.maizi.fund.model.domain.ImpalaDemo;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/11 11:12 上午
 */
public interface EmployeeService {
    List<Employee> selectAll();

    List<Employee> selectById(String searchValue);

    Employee selectOne();

    List<ImpalaDemo> selectImpala();
}
