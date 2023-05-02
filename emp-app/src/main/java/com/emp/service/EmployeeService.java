package com.emp.service;

import com.emp.domain.Currency;
import com.emp.domain.Employee;
import com.emp.dto.Employeedto;
import com.emp.util.JsonReaderutil;
import org.apache.commons.collections4.CollectionUtils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    private List<Employee> employees;
    private Map<String, Currency> currencyMap;

    public EmployeeService() {
    this.employees = JsonReaderutil.loademployees();
    this.currencyMap = JsonReaderutil.loadcurrency();
    }
    public List<Employeedto> getemployeewfs(){
        List<Employeedto> list = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(employees)){
            for(Employee emp:employees){
                Currency currency = currencyMap.getOrDefault(emp.getCurrency(),defaultcurrency());
                Employeedto employeedto = formatEmp(emp,currency);
                list.add(employeedto);
            }
            return list;
        }
        else{
            System.out.println("Employees list is empty");
        }
        return list;
    }

    private Currency defaultcurrency() {
        Currency currency = new Currency();
        currency.setSymbol("$");
        currency.setDecimal_digits(2);
        return currency;
    };

    private Employeedto formatEmp(Employee emp, Currency currency) {
        int decimalplaces = currency.getDecimal_digits();
        String symbol = currency.getSymbol();
        double salary = emp.getSalary();
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(decimalplaces);
        String formattedSalary = String.format("%s %s",symbol,format.format(salary));
        Employeedto empdto = Employeedto.builder()
                .firstname(emp.getFirstname())
                .lastname(emp.getLastname())
                .email(emp.getEmail())
                .gender(emp.getGender())
                .formatedsalary(formattedSalary)
                .salary(emp.getSalary())
                .currency(emp.getCurrency()).build();
return empdto;
    }
}
