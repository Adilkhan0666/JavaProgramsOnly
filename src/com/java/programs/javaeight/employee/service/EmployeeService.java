package com.java.programs.javaeight.employee.service;

import com.java.programs.javaeight.employee.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService {

    static List<EmployeeDto> employeeDtos = new ArrayList<>();
    static {


        EmployeeDto employeeDto1 = new EmployeeDto("1","Adil","11","active",10000);
        EmployeeDto employeeDto2 = new EmployeeDto("2","Abid","22","active",20000);
        EmployeeDto employeeDto3 = new EmployeeDto("3","Muzammil","33","active",30000);
        EmployeeDto employeeDto4 = new EmployeeDto("4","Yogesh","44","active",40000);
        EmployeeDto employeeDto5 = new EmployeeDto("5","Danish","55","active",50000);
        EmployeeDto employeeDto6 = new EmployeeDto("6","Asif","66","Inactive",60000);
        EmployeeDto employeeDto7 = new EmployeeDto("7","Kasif","77","Inactive",70000);
        EmployeeDto employeeDto8 = new EmployeeDto("8","Zuaib","88","Inactive",80000);
        EmployeeDto employeeDto9 = new EmployeeDto("9","Karim","99","Inactive",90000);

        employeeDtos.add(employeeDto1);
        employeeDtos.add(employeeDto2);
        employeeDtos.add(employeeDto3);
        employeeDtos.add(employeeDto4);
        employeeDtos.add(employeeDto5);
        employeeDtos.add(employeeDto6);
        employeeDtos.add(employeeDto7);
        employeeDtos.add(employeeDto8);
        employeeDtos.add(employeeDto9);

    }

    public void retrieveAllEmployee(){
        employeeDtos.stream().forEach(System.out::println);
    }

    public List<EmployeeDto> retrieveByEmpName(){
        List<EmployeeDto> list = employeeDtos.stream().filter(employeeDto -> employeeDto.getEmpName().startsWith("Adil1")).collect(Collectors.toList());
        return list;
    }

    public List<String> retrieveEmpNameOnly(){
        List<String> empName = employeeDtos.stream().map(employeeDto -> employeeDto.getEmpName()).collect(Collectors.toList());
        return empName;
    }

    public List<String> retrieveEmpIdOnly(){
        List<String> empIds = employeeDtos.stream().map(EmployeeDto::getEmpId).collect(Collectors.toList());
        return empIds;
    }

    public List<EmployeeDto> retrieveEmpByActiveSatusOnly(){
        return employeeDtos.stream().filter(employeeDto -> employeeDto.getStatus().equals("active")).collect(Collectors.toList());
    }

    public List<String> retrieveEmpNameByActiveStatus(){
        return employeeDtos.stream().filter(employeeDto -> employeeDto.getStatus().equals("active"))
                .flatMap(employeeDto -> Stream.of(employeeDto.getEmpId(),employeeDto.getEmpName()))
                .collect(Collectors.toList());
    }
    public List<String> retrieveEmpNameEmpStatusEmpSalary(){

//        Stream stream = employeeDtos.stream().map(employeeDto -> employeeDto.getEmpName());
//        String w = String.valueOf(stream.collect(Collectors.toList()));
//        System.out.println("wwwwwwwwww "+w);

        return employeeDtos.stream().flatMap(employeeDto -> Stream.of(employeeDto.getEmpName(),employeeDto.getStatus(),String.valueOf(employeeDto.getSalary())))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> retrieveByStatusChangeNameFirstCharAToS(){

        List<EmployeeDto> strings =        employeeDtos.stream()
                .peek(f->f.setEmpName(f.getEmpName().replace("A","S")))
                .filter(a  -> a.getStatus().equalsIgnoreCase("Active") && a.getEmpName().startsWith("S"))
                .collect(Collectors.toList());


        return  strings;

    }

    public List<EmployeeDto> retrieveAllEmployeeMakeStatusActiveToInactive() {
        return employeeDtos.stream()
                .filter(employeeDto -> employeeDto.getStatus().equalsIgnoreCase("Active"))
                .peek(employeeDto -> employeeDto.setStatus("InnActive"))
                .collect(Collectors.toList());
    }

    /**
     * fetching employee salary less than 50,000 and giving bonus of 10,000
     * @return list of employee
     */
    public List<EmployeeDto> retrieveEmpSalaryLessFiftyTh(){
        return employeeDtos.stream().filter(data -> data.getSalary()<50000).peek(salIncrement -> salIncrement.setSalary(salIncrement.getSalary()+10000))
                .collect(Collectors.toList());

    }


}
