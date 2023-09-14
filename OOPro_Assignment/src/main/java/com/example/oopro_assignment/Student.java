package com.example.oopro_assignment;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private String Name;
    private String ID;
    private String DOB;
    private ArrayList<Module> StudentModule;



    public Student(String _name, String _ID, String _DOB){
        this.Name = _name;
        this.ID = _ID;
        this.DOB = _DOB;
        this.StudentModule = new ArrayList<Module>();


    }

    public String getStudentName(){
        return Name;
    }

    public void setStudentName(String name){
        this.Name = name;
    }

    public String getStudentID(){
        return ID;
    }

    public void setStudentID(String id){
        this.ID = id;
    }

    public String getStudentDOB(){
        return DOB;
    }

    public void setStudentDOB(String dob){
        this.DOB = dob;
    }

    public String toString(){
        String string = Name + " " + ID + " " + DOB + "\n";
        return string;
    }

    public int compareTo(Student s){
        int compared = this.Name.compareTo(s.getStudentName());
        if(compared != 0){
            return compared;
        }
        else{
            return this.ID.compareTo(s.getStudentID());
        }
    }
}
