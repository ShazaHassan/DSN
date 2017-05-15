package com.example.android.dsn;

/**
 * Created by ShazaHassan on 15-May-17.
 */

public class User {
    String Name,Email,Password,Department;
    public User() {
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getDepartment() {
        return Department;
    }
}
class Student{
    String Name,Email,Password,Department,AcadmicYear;

    public Student() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getAcadmicYear() {
        return AcadmicYear;
    }

    public void setAcadmicYear(String acadmicYear) {
        AcadmicYear = acadmicYear;
    }
}
