package com.java.programs.javaeight.employee.main;

import com.java.programs.javaeight.employee.service.EmployeeService;

public class Employee {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        System.out.println();
        System.out.println("fetching all employee details");
        employeeService.retrieveAllEmployee();

//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee details By name starting with A");
//        System.out.println(employeeService.retrieveByEmpName());
//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee details By name ");
//        System.out.println(employeeService.retrieveEmpNameOnly());
//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee details By Ids ");
//        System.out.println(employeeService.retrieveEmpIdOnly());
//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee details By Active Status ");
//        System.out.println(employeeService.retrieveEmpByActiveSatusOnly());
//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee Name By Active Status ");
//        System.out.println(employeeService.retrieveEmpNameByActiveStatus());
//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee Name  ");
//        System.out.println(employeeService.retrieveEmpNameEmpStatusEmpSalary());
//        System.out.println();
//        System.out.println();
//        System.out.println("fetching all employee  ");
//        System.out.println(employeeService.retrieveByStatusChangeNameFirstCharAToS());
        System.out.println();
        System.out.println();
        System.out.println("fetching all employee  names ");
        System.out.println(employeeService.retrieveAllEmployeeMakeStatusActiveToInactive());

    }
}
