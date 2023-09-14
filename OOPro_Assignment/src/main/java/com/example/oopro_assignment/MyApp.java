package com.example.oopro_assignment;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class MyApp extends Application {
    public static void main(String[] args){
        launch(args);
    }


    Button add, remove, list, save, load, exit, addModule ,orderModule,orderStudent;

    Label name, id, dob,record,adding,module,moduleName,moduleGrade;
    TextField nameTxt, idTxt, dobTxt,moduleNameTxt, moduleGradeTxt;


    ListView<String> listStudents;


    ChoiceBox<String> dropdown;



    private static RecordController recordControl = new RecordController();







    @Override
    public void start(Stage stage){



            stage.setTitle("MTU Student Record");

            name = new Label("Enter name of Student");
            nameTxt = new TextField();

            id = new Label("Enter Student ID");
            idTxt = new TextField();

            dob = new Label("Enter Student DOB");
            dobTxt = new TextField();

            add = new Button("Add");
            add.setOnAction(e -> recordControl.addStudentToTheList(nameTxt.getText(), idTxt.getText(), dobTxt.getText()));



            remove = new Button("Remove");
            remove.setOnAction(e -> {
                        int selected = listStudents.getSelectionModel().getSelectedIndex();
                        listStudents.getItems().remove(selected);
                    }
            );



            list = new Button("List");
            list.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    

                    String AllStudents = recordControl.getTheListOfStudents();
                    listStudents.getItems().add(AllStudents);



                }
            });


            record = new Label("Student Records Display");
            listStudents = new ListView<>();


            save = new Button("Save");
            save.setOnAction(e -> recordControl.saveRecords(recordControl.getStudentList().getStudentsList()));

            load = new Button("Load");
            load.setOnAction(e -> recordControl.loadRecord(recordControl.getStudentList().getStudentsList()));


            exit = new Button("Exit");
            exit.setOnAction(e -> RecordController.exiting("Exiting", "Are you sure?"));

            adding = new Label("Add a Student");

            module = new Label ("Student Modules");

            moduleName = new Label("Enter Module Name");
            moduleNameTxt = new TextField();
            moduleGrade = new Label ("Enter Module Grade");
            moduleGradeTxt = new TextField();


            dropdown = new ChoiceBox<>();

            dropdown.getItems().addAll();

            addModule = new Button("Add Module Details");
            addModule.setOnAction(e -> recordControl.addModuleToTheList(moduleName.getText(),moduleGrade.getText()));

            orderStudent = new Button("Sort by Student");
            orderStudent.setOnAction(e -> recordControl.StudentSorting());
            orderModule = new Button("Sort by Module");




            //title for adding students
            HBox addingTitle = new HBox();
            addingTitle.getChildren().addAll(adding);
            addingTitle.setAlignment(Pos.BASELINE_CENTER);

            // box for Name details
            HBox s1 = new HBox(10);
            s1.setAlignment(Pos.BASELINE_CENTER);
            s1.setPadding(new Insets(5));
            s1.getChildren().addAll(name, nameTxt);

        // box for id details
            HBox s2 = new HBox(10);
            s2.setAlignment(Pos.BASELINE_CENTER);
            s2.setPadding(new Insets(5));
            s2.getChildren().addAll(id, idTxt);

            // box for dob details
            HBox s3 = new HBox(10);
            s3.setAlignment(Pos.BASELINE_CENTER);
            s3.setPadding(new Insets(5));
            s3.getChildren().addAll(dob, dobTxt);


            // box for buttons
            HBox s4 = new HBox(10);
            s4.getChildren().addAll(add);
            s4.setAlignment(Pos.BASELINE_CENTER);
            s4.setPadding(new Insets(5));

            // box for record details
            HBox s5 = new HBox();
            s5.getChildren().addAll(record);
            s5.setAlignment(Pos.BASELINE_CENTER);
            s5.setPadding(new Insets(10));


            //box for list and remove button
            HBox s6 = new HBox(30);
            s6.getChildren().addAll(list,remove,save,load);
            s6.setAlignment(Pos.BASELINE_CENTER);
            s6.setPadding(new Insets(10));

            // for student records
            HBox s7 = new HBox();
            s7.getChildren().addAll(listStudents);
            s7.setAlignment(Pos.BASELINE_CENTER);

            // module title
            HBox s8 = new HBox();
            s8.getChildren().addAll(module);
            s8.setAlignment(Pos.BASELINE_CENTER);

            // module name details
            HBox s9 = new HBox(10);
            s9.getChildren().addAll(moduleName,moduleNameTxt);
            s9.setAlignment(Pos.BASELINE_CENTER);
            s9.setPadding(new Insets(5));

            // module grade details
            HBox s10 = new HBox(10);
            s10.getChildren().addAll(moduleGrade,moduleGradeTxt);
            s10.setAlignment(Pos.BASELINE_CENTER);
            s10.setPadding(new Insets(5));

            //exit button
            HBox s11 = new HBox();
            s11.getChildren().addAll(exit);
            s11.setAlignment(Pos.BASELINE_CENTER);
            s11.setPadding(new Insets(150));

            // drop down menu
            HBox s12 = new HBox();
            s12.getChildren().addAll(dropdown);
            s12.setAlignment((Pos.BASELINE_CENTER));

            // add modules button and sort by
            HBox s13 = new HBox(10);
            s13.getChildren().addAll(addModule);
            s13.setAlignment(Pos.BASELINE_CENTER);
            s13.setPadding(new Insets(5));

            HBox s14 = new HBox(10);
            s14.getChildren().addAll(orderStudent,orderModule);
            s14.setAlignment(Pos.BASELINE_CENTER);


            //layout of all boxes
            VBox addLayout = new VBox();

            addLayout.getChildren().addAll(addingTitle,s1, s2, s3, s4,s11);

            VBox moduleLayout = new VBox();
            moduleLayout.getChildren().addAll(s8,s12,s9,s10,s13);

            VBox listLayout = new VBox();
            listLayout.getChildren().addAll(s14,s5,s6,s7);



            // tabs layout
            Group root = new Group();
            TabPane menu = new TabPane();
            BorderPane main = new BorderPane();
            menu.setSide(Side.LEFT);

            Tab addTab = new Tab("Add Students", addLayout);
            addTab.setClosable(false);
            Tab moduleTab = new Tab("Student Modules",moduleLayout);
            moduleTab.setClosable(false);
            Tab listTab = new Tab("Student Records",listLayout);
            listTab.setClosable(false);

            menu.getTabs().addAll(addTab,moduleTab,listTab);

            main.setCenter(menu);




            root.getChildren().add(main);
            Scene scene = new Scene(root, 400, 400);




            //setting scene
            stage.setScene(scene);
            stage.show();

    }
}
