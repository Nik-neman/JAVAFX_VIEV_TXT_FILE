/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;

public class Controller {

    //    String filePathName ="C:\\Users\\Nikolai\\Documents";
    String filePathName;
    private Stage stage;


    @FXML // fx:id="chose"
    private Button chose; // Value injected by FXMLLoader

    @FXML // fx:id="textPath"
    private TextField textPath; // Value injected by FXMLLoader

    @FXML // fx:id="textViev"
    private TextArea textViev; // Value injected by FXMLLoader


    @FXML // fx:id="viev"
    private Button viev; // Value injected by FXMLLoader


    @FXML
    void ChooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать текстовый файл");
        // Задаём фильтр расширений
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
//        fileChooser.setInitialDirectory(new File(System.getProperty(filePathName)));
//        // Показываем диалог загрузки файла
//        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        File selectedFile = fileChooser.showOpenDialog(stage);
//        if (selectedFile != null) {
//           stage.display(selectedFile);
//        }


        if (selectedFile != null) {
            filePathName = selectedFile.getPath();
            if(textPath!= null) {
                textPath.appendText(filePathName.toString());
//            System.out.println(filePathName);
            } else {
                textPath.appendText("Файл не выбран. Попробуйте ещё раз");
            }
        }

    }

    @FXML
    void vievFile(ActionEvent event) {
//        System.out.println("hjgrhfuk");
        BufferedReader bufferedReader = null;
        String string;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePathName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();


        try {
            while ((string = bufferedReader.readLine())!=null){
                stringBuilder.append(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        textViev.appendText(stringBuilder.toString());
    }

}
