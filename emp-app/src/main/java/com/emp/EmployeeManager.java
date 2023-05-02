package com.emp;

import com.emp.dto.Employeedto;
import com.emp.service.EmployeeService;

import java.util.List;

public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeService emps = new EmployeeService();
        emps.getemployeewfs().forEach(ele->
                System.out.println(ele.getFirstname()+", "+ele.getLastname()+", "+ele.getGender()+", "+ele.getEmail()+", "+ele.getFormatedsalary()+", "+ele.getSalary()+",  "+ele.getCurrency()));

    }
}
