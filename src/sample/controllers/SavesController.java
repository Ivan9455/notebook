package sample.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;


public class SavesController {
    @FXML
    private TextField filename;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @FXML
    private Button saveid;

    @FXML
    private Button cancel;

    @FXML
    private AnchorPane anchorPane;

    @FXML

    public void clicBtn(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        Button clickedButton = (Button) source;
        switch (clickedButton.getId()){
            case "saveid":
                try {
                    FileWriter fileWriter = new FileWriter(filename.getText());
                    fileWriter.write(text);
                    fileWriter.flush();
                    fileWriter.close();
                    anchorPane.getScene().getWindow().hide();
                }
                catch (IOException e){
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

}
