package com.maizi.fund.service.impl;

import com.maizi.fund.mapper.EmployeeMapper;
import com.maizi.fund.model.domain.Employee;
import com.maizi.fund.model.domain.ImpalaDemo;
import com.maizi.fund.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/11 11:13 上午
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public List<Employee> selectById(String searchValue) {
        return employeeMapper.selectById(searchValue);
    }


    @Override
    public Employee selectOne() {
        return employeeMapper.selectOne();
    }

    @Override
    public List<ImpalaDemo> selectImpala() {
        return employeeMapper.selectImpala();
    }
}
