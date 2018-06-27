package java.com.virusanalyzer.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.com.virusanalyzer.reportgenerator.ReportGenerator;
import java.com.virusanalyzer.virusscanner.ExtensionScanner;
import java.com.virusanalyzer.virusscanner.HashScanner;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField txtPath;

    @FXML
    private Button btnBrowse;

    @FXML
    private Button btnScan;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnClear;

    private FileChooser fileChooser;
    private File file;
    private String path;

    @FXML
    void browse(MouseEvent event) {
        Stage stage = (Stage) btnBrowse.getScene().getWindow();
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            path = file.getAbsolutePath();
            txtPath.setText(path);
        }
    }

    @FXML
    void clear(MouseEvent event) {
        txtArea.clear();
    }

    @FXML
    void scan(MouseEvent event) {
        ReportGenerator.clear();
        ExtensionScanner.extensionScan(path);
        HashScanner.getHashScanner().checkHash(path);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
    }
}
