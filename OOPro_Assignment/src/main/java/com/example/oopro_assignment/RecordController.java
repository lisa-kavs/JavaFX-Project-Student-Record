package com.example.oopro_assignment;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecordController implements Serializable {

    private StudentList st;
    private ModuleList m;

    public RecordController(){
        st = new StudentList();
        m = new ModuleList();
    }

    public void addStudentToTheList(String stName, String stID, String stDOB){
        Student s = new Student(stName, stID, stDOB);
        st.addStudent(s);


    }
    public void addModuleToTheList(String mName, String mGrade){
        Module mo = new Module(mName, mGrade);
        m.addModule(mo);
    }
    public StudentList getStudentList(){
        return st;
    }

    public ModuleList getModuleList(){return m;}


    public String getTheListOfStudents(){
        String AllStudents = "";
        if (st.getSize() == 0){
            return "Our Records are Empty!";
        } else {
            for (int i = 0; i < st.getSize(); i++) {
                AllStudents = AllStudents + st.getStudent(i);
            }
        }
        return AllStudents;
    }

    public String getTheListOfModules(){
        String AllModules = "";
        if(m.getModuleSize() == 0){
            return "Our Records are Empty!";

        }
        else{
            for (int i = 0; i < m.getModuleSize(); i++){
                AllModules = AllModules + m.getModule(i);
            }
        }
        return AllModules;
    }

 public static void exiting(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(150);
        window.setMinWidth(300);

       Label Message = new Label(message);


       Button exit = new Button("Exit");
       exit.setOnAction(e -> System.exit(0));
       Button cancel = new Button("Cancel");
       cancel.setOnAction(e -> window.close());

       HBox buttons = new HBox(10);
       buttons.getChildren().addAll(exit,cancel);
       buttons.setAlignment(Pos.BASELINE_CENTER);
       buttons.setPadding(new Insets(2));

       VBox vboxClose = new VBox(10);
       vboxClose.getChildren().addAll(Message,buttons);
       vboxClose.setAlignment(Pos.BASELINE_CENTER);

       Scene exitingScene = new Scene(vboxClose);
       window.setScene(exitingScene);
       window.showAndWait();

 }




public void saveRecords(ArrayList<Student> studentList){
    try {
        String displayFile = "";
        FileWriter studentFile = new FileWriter("C:\\Users\\lisak\\IdeaProjects\\OOPro_Assignment\\src\\main\\java\\com\\example\\oopro_assignment\\student.txt");

        for (Student s : studentList) {
            displayFile += s.getStudentName() + "," + s.getStudentID() + "," + s.getStudentDOB() + "\n";
        }

        studentFile.write(displayFile);
        studentFile.close();
        System.out.println("File Saved!");
    }catch(Exception e1) {
        System.out.print("There has been an error!");
    }


}


public ArrayList<Student> loadRecord(ArrayList<Student> studentList){

        try{
            FileReader fileReader = new FileReader("C:\\Users\\lisak\\IdeaProjects\\OOPro_Assignment\\src\\main\\java\\com\\example\\oopro_assignment\\student.txt");
            BufferedReader input = new BufferedReader(fileReader);
            String line =  input.readLine();

            studentList.clear();
            while (line != null){
                String[] info = line.split(",");
                studentList.add(new Student(info[0], info[1], info[2]));
                line = input.readLine();
            }
            input.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return studentList;
}


public void saveBySerial(ArrayList<Student> studentList){
        String filename = "students.ser";

        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(studentList);

            out.close();
            file.close();
        }
        catch (IOException ex){
            System.out.println("Exception Caught!");
        }

}

public void loadBySerial(ArrayList<Student> studentList){
        String filename = "students.ser";
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

//            in.readObject(studentList);

            in.close();
            file.close();
        }
        catch (IOException ex){
            System.out.println("Exception Caught!");
        }

}

public void StudentSorting(){
        st.sortingStudent();
}



}
