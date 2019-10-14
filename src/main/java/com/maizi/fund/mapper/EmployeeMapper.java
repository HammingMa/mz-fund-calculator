package com.maizi.fund.mapper;

import com.maizi.fund.model.domain.Employee;
import com.maizi.fund.model.domain.ImpalaDemo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/11 11:02 上午
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 获取单条记录, 通过 xml
     * @return
     */
    Employee selectOne();

    /**
     * 获取所有
     * @return Employee
     */
    @Select("select * from employee;")
    List<Employee> selectAll();


    @Select("select * from msc.abc1234;")
    List<ImpalaDemo> selectImpala();

    /**
     * 根据 SEX 获取数据
     * @param searchValue
     * @return Employee
     */
    @Select("select * from employee where SEX=#{search_value};")
    List<Employee> selectById(@Param("search_value") String searchValue);


}