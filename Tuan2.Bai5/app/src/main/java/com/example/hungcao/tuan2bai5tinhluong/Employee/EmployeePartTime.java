package com.example.hungcao.tuan2bai5tinhluong.Employee;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Part time ="  + tinhLuong();
    }
}
