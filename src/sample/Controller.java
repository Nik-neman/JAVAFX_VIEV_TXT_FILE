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
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    //    String filePathName ="C:\\Users\\Nikolai\\Documents";
    String filePathName = null;
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

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            filePathName = selectedFile.getPath();
            if(filePathName!= null) {
                textPath.clear();
                textPath.appendText(filePathName.toString());
            } else {
                textPath.appendText("Файл не выбран. Попробуйте ещё раз");
            }
        }
    }

    @FXML
    void vievFile(ActionEvent event) {
        String path = textPath.getText();

        if(path!= null) {

            BufferedReader bufferedReader = null;
            String string;

            try {
                bufferedReader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
//                textViev.clear();
                textViev.appendText("Текстовый файл не найден. Попробуйте ещё раз.\n");
            }
            StringBuilder stringBuilder = new StringBuilder();

            try {
                while ((string = bufferedReader.readLine()) != null) {
                    stringBuilder.append(string + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                textViev.clear();
                textViev.appendText("Ошибка чтения файла. Попробуйте ещё раз\n");
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            textViev.setText(stringBuilder.toString());

        } else if(path == "" || path == null){
            textViev.clear();
            textViev.appendText("Текстовый файл не найден. Попробуйте ещё раз.\n");
        }
    }
}
