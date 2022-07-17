package com.java.programs.javaeight.employee.dto;

public class EmployeeDto {


    private String empId;
    private String empName;
    private String depId;
    private String status = "active";
    private int salary;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public EmployeeDto(String empId, String empName, String depId, String status, int salary) {
        this.empId = empId;
        this.empName = empName;
        this.depId = depId;
        this.status = status;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", depId='" + depId + '\'' +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }


}
