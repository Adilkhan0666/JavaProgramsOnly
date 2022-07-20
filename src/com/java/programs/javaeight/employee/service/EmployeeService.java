package com.java.programs.javaeight.employee.service;

import com.java.programs.javaeight.employee.dto.EmployeeDto;
import com.java.programs.javaeight.employee.main.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService {

    static List<EmployeeDto> employeeTcs = new ArrayList<>();
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

        employeeTcs.add(employeeDto1);
        employeeTcs.add(employeeDto2);
        employeeTcs.add(employeeDto3);
        employeeTcs.add(employeeDto4);
        employeeTcs.add(employeeDto5);
        employeeTcs.add(employeeDto6);
        employeeTcs.add(employeeDto7);
        employeeTcs.add(employeeDto8);
        employeeTcs.add(employeeDto9);

    }
    static List<EmployeeDto> employeeDeloitte = new ArrayList<>();
    static {

        EmployeeDto employeeDeloitte1 = new EmployeeDto("11","Adil","11","active",10000);
        EmployeeDto employeeDeloitte2 = new EmployeeDto("22","Abid","22","active",20000);
        EmployeeDto employeeDeloitte3 = new EmployeeDto("33","Aditya","33","active",30000);
        EmployeeDto employeeDeloitte4 = new EmployeeDto("44","Yogesh","44","active",40000);
        EmployeeDto employeeDeloitte5 = new EmployeeDto("55","Shivansh","55","active",50000);
        EmployeeDto employeeDeloitte6 = new EmployeeDto("66","Asif","66","Inactive",60000);
        EmployeeDto employeeDeloitte7 = new EmployeeDto("77","Amar","77","Inactive",70000);
        EmployeeDto employeeDeloitte8 = new EmployeeDto("88","Zuaib","88","Inactive",80000);
        EmployeeDto employeeDeloitte9 = new EmployeeDto("99","Karim","99","Inactive",90000);

        employeeDeloitte.add(employeeDeloitte1);
        employeeDeloitte.add(employeeDeloitte2);
        employeeDeloitte.add(employeeDeloitte3);
        employeeDeloitte.add(employeeDeloitte4);
        employeeDeloitte.add(employeeDeloitte5);
        employeeDeloitte.add(employeeDeloitte6);
        employeeDeloitte.add(employeeDeloitte7);
        employeeDeloitte.add(employeeDeloitte8);
        employeeDeloitte.add(employeeDeloitte9);

    }


    public void retrieveAllEmployee(){
        employeeTcs.stream().forEach(System.out::println);
    }

    public List<EmployeeDto> retrieveByEmpName(){
        List<EmployeeDto> list = employeeTcs.stream().filter(employeeDto -> employeeDto.getEmpName().startsWith("Adil1")).collect(Collectors.toList());
        return list;
    }

    public List<String> retrieveEmpNameOnly(){
        List<String> empName = employeeTcs.stream().map(employeeDto -> employeeDto.getEmpName()).collect(Collectors.toList());
        return empName;
    }

    public List<String> retrieveEmpIdOnly(){
        List<String> empIds = employeeTcs.stream().map(EmployeeDto::getEmpId).collect(Collectors.toList());
        return empIds;
    }

    public List<EmployeeDto> retrieveEmpByActiveSatusOnly(){
        return employeeTcs.stream().filter(employeeDto -> employeeDto.getStatus().equals("active")).collect(Collectors.toList());
    }

    public List<String> retrieveEmpNameByActiveStatus(){
        return employeeTcs.stream().filter(employeeDto -> employeeDto.getStatus().equals("active"))
                .flatMap(employeeDto -> Stream.of(employeeDto.getEmpId(),employeeDto.getEmpName()))
                .collect(Collectors.toList());
    }
    public List<String> retrieveEmpNameEmpStatusEmpSalary(){

//        Stream stream = employeeDtos.stream().map(employeeDto -> employeeDto.getEmpName());
//        String w = String.valueOf(stream.collect(Collectors.toList()));
//        System.out.println("wwwwwwwwww "+w);

        return employeeTcs.stream().flatMap(employeeDto -> Stream.of(employeeDto.getEmpName(),employeeDto.getStatus(),String.valueOf(employeeDto.getSalary())))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> retrieveByStatusChangeNameFirstCharAToS(){

        List<EmployeeDto> strings =        employeeTcs.stream()
                .peek(f->f.setEmpName(f.getEmpName().replace("A","S")))
                .filter(a  -> a.getStatus().equalsIgnoreCase("Active") && a.getEmpName().startsWith("S"))
                .collect(Collectors.toList());


        return  strings;

    }

    public List<EmployeeDto> retrieveAllEmployeeMakeStatusActiveToInactive() {
        return employeeTcs.stream()
                .filter(employeeDto -> employeeDto.getStatus().equalsIgnoreCase("Active"))
                .peek(employeeDto -> employeeDto.setStatus("InnActive"))
                .collect(Collectors.toList());
    }

    /**
     * fetching employee salary less than 50,000 and giving bonus of 10,000
     * @return list of employee
     */
    public List<EmployeeDto> retrieveEmpSalaryLessFiftyTh(){
        return employeeTcs.stream().filter(data -> data.getSalary()<50000).peek(salIncrement -> salIncrement.setSalary(salIncrement.getSalary()+10000))
                .collect(Collectors.toList());

    }

    public void getDeloitteEmployeeList(){
        employeeDeloitte.stream().forEach(System.out::println);
    }

    public List<EmployeeDto> getCommonEmployeeInTCSAndDeloitte(){

        return employeeTcs.stream()
                .filter(tcsList -> employeeDeloitte.stream()
                        .anyMatch(deloitteList ->
                                deloitteList.getEmpName().equals(tcsList.getEmpName())
                        )).collect(Collectors.toList());
    }
    public List<EmployeeDto> getCommonEmployeeInTCSAndDeloitte1(){
    ArrayList<EmployeeDto> ll = new ArrayList<>();
         employeeTcs.stream().forEach(
                tcsList -> employeeDeloitte.stream().filter(
                        deloitteList ->tcsList.getEmpName().equals(deloitteList.getEmpName())
                        )
                        .forEach(data -> ll.add(tcsList)));

        return ll;
    }

}
