package sample.controllers;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;


import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class OpenFileControllers {

    @FXML
    private TableColumn<String,String> path;

    @FXML
    private TableView table;

    @FXML
    private Button open;

    @FXML
    private Button cancel;

    @FXML
    private AnchorPane anchorPane;

    public void clicbtn(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();
        Button clickedButton = (Button) source;
        switch (clickedButton.getId()) {
            case "open":
                try {
                    FileWriter fileWriter = new FileWriter("1");
//                        fileWriter.write(text);
//                        fileWriter.flush();
//                        fileWriter.close();
//                        anchorPane.getScene().getWindow().hide();
                } catch (IOException e) {
                    System.out.println("erorr!");
                }
                break;
            case "cancel":
                anchorPane.getScene().getWindow().hide();
                break;
            default:
                break;
        }
    }
    @FXML
    private void initialize() {
        String paths = new File("/").getAbsolutePath();
        path.setText(paths);




    }
//        File dir1 = new File("/");
//        for (int i = 0; i < dir1.list().length; i++) {
//            System.out.println(dir1.list()[i]);
//        }
    }

