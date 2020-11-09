package com.example.studentinfo;

public class StudentModel {
    private String student_id;
    private String m1;
    private String m2;
    private String m3;

    public StudentModel() {
    }

    public StudentModel(String student_id, String m1, String m2, String m3) {
        this.student_id = student_id;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }
}
