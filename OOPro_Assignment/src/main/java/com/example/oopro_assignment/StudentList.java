package com.example.oopro_assignment;

import java.util.ArrayList;
import java.util.Collections;


public class StudentList {

    private ArrayList<Student> student;

    public StudentList(){
        student = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudentsList(){
        return student;
    }

    public void addStudent(Student st){
        student.add(st);

    }



    public Student getStudent(int i){
        if((i>-1)&&(i < student.size())) {
            return student.get(i);
        }

        return null;
    }

    public int getSize(){
        return student.size();
    }

    public void sortingStudent(){
        Collections.sort(student);
    }

}
