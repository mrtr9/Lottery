package com.tr9.lottery.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 20:21
 */
public class MainController implements Initializable {

    @FXML
    private TextArea resultTextArea;

    @FXML
    private TextField startTextField;

    @FXML
    private TextField endTextField;

    @FXML
    private ChoiceBox numChoiceBox;


    public void initialize(URL location, ResourceBundle resources) {
        resultTextArea.setEditable(false);
    }

}
