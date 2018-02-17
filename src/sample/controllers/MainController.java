package sample.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;



import java.io.IOException;

public class MainController {


    private Parent fxmlSavesOpen;

    private FXMLLoader fxmlLoaderSavesOpen = new FXMLLoader();

    private OpenFileControllers openFileControllers;

    private Stage windowDialogStageOpen;


    private Parent fxmlSaves;

    private FXMLLoader fxmlLoaderSaves = new FXMLLoader();

    private SavesController savesController;

    private Stage windowDialogStage;

    @FXML
    private TextArea textArea;

    public TextArea getTextArea() {
        return textArea;
    }

    @FXML
    private AnchorPane anchorPane;


    public void filePresed(ActionEvent actionEvent) throws IOException {
        Object source = actionEvent.getSource();
        MenuItem clickedButton = (MenuItem) source;
        switch (clickedButton.getId()) {
            case "open":
                System.out.println("Нажата кнопка  " + clickedButton.getId());
                showDialogOpenFile(anchorPane.getScene().getWindow());

            case "save":
                System.out.println("Нажата кнопка  " + clickedButton.getId());
                //showDialog(anchorPane.getScene().getWindow());

                break;
            case "saves":
                System.out.println("Нажата кнопка  " + clickedButton.getId());
                savesController.setText(textArea.getText());
                showDialog(anchorPane.getScene().getWindow());

                break;
            case "exit"://работает выход
                System.out.println("Нажата кнопка  " + clickedButton.getId());
                anchorPane.getScene().getWindow().hide();

                break;
            default:
                System.out.println("default!");
                break;
        }
    }

    @FXML
    private void initialize() {
        try {
            fxmlLoaderSaves.setLocation(getClass().getResource("../fxml/saves.fxml"));
            fxmlSaves = fxmlLoaderSaves.load();
            savesController = fxmlLoaderSaves.getController();

            fxmlLoaderSavesOpen.setLocation(getClass().getResource("../fxml/openFile.fxml"));
            fxmlSavesOpen = fxmlLoaderSavesOpen.load();
            openFileControllers = fxmlLoaderSavesOpen.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDialog(Window parentWindow) {

        if (windowDialogStage == null) {
            windowDialogStage = new Stage();
            windowDialogStage.setTitle("Сохранить как");
            windowDialogStage.setMinHeight(100);
            windowDialogStage.setMinWidth(200);
            windowDialogStage.setResizable(false);
            windowDialogStage.setScene(new Scene(fxmlSaves));
            windowDialogStage.initModality(Modality.WINDOW_MODAL);
            windowDialogStage.initOwner(parentWindow);
        }
        //windowDialogStage.showAndWait(); // для ожидания закрытия окна
        windowDialogStage.show();
    }


    private void showDialogOpenFile(Window parentWindow) {

        if (windowDialogStageOpen == null) {
            windowDialogStageOpen = new Stage();
            windowDialogStageOpen.setTitle("Открыть");
            windowDialogStageOpen.setMinHeight(200);
            windowDialogStageOpen.setMinWidth(300);
            windowDialogStageOpen.setResizable(false);
            windowDialogStageOpen.setScene(new Scene(fxmlSavesOpen));
            windowDialogStageOpen.initModality(Modality.WINDOW_MODAL);
            windowDialogStageOpen.initOwner(parentWindow);
        }
        //windowDialogStage.showAndWait(); // для ожидания закрытия окна
        windowDialogStageOpen.show();
    }
}
