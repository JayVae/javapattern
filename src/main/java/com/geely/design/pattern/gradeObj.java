package com.geely.design.pattern;

public class gradeObj implements Comparable<gradeObj> {

    private int grade ;
    private String column;

    public gradeObj(int grade, String column) {
        this.grade = grade;
        this.column = column;
    }


    @Override
    public int compareTo(gradeObj o) {
        if (this.grade < o.grade){
            return 1;
        }else if (this.grade > o.grade){
            return -1;
        }else {
            return 0;
        }
    }

    public int getGrade() {
        return grade;
    }

    public String getColumn() {
        return column;
    }
}
