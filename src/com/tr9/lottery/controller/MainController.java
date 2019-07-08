package com.tr9.lottery.controller;

import com.tr9.lottery.bean.Bean;
import com.tr9.lottery.service.Service;
import com.tr9.lottery.service.impl.ServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 20:21
 */
public class MainController implements Initializable {

    private Service service = new ServiceImpl();
    private List<Bean> list = null;

    @FXML
    private TextArea resultTextArea;

    @FXML
    private TextField startTextField;

    @FXML
    private TextField endTextField;

    @FXML
    private TableView tableView;

    @FXML
    private ChoiceBox numChoiceBox;


    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("请选择");
        list.add("近10期");
        list.add("近20期");
        list.add("近30期");
        list.add("近40期");
        list.add("近50期");
        list.add("近60期");
        list.add("近70期");
        list.add("近80期");
        list.add("近90期");
        list.add("近100期");
        numChoiceBox.setItems(list);
        numChoiceBox.getSelectionModel().select(0);
        resultTextArea.setEditable(false);
    }

    @FXML
    public void search() {
        int num = getNum();
        if(num > 0){
            try {
                list = service.list(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startTextField.getText().length() > 0 && endTextField.getText().length() > 0) {
                list = service.list(list, startTextField.getText(), endTextField.getText());
            } else {
                ObservableList dataList = FXCollections.observableList(list);
                tableView.setItems(dataList);
            }
        }
    }

    private int getNum() {
        int index = numChoiceBox.getSelectionModel().getSelectedIndex();
        int num = 0;
        switch (index) {
            case 0:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("错误提示");
                alert.setContentText("请选择期数");
                alert.showAndWait();
                break;
            case 1:
                num = 10;
                break;
            case 2:
                num = 20;
                break;
            case 3:
                num = 30;
                break;
            case 4:
                num = 40;
                break;
            case 5:
                num = 50;
                break;
            case 6:
                num = 60;
                break;
            case 7:
                num = 70;
                break;
            case 8:
                num = 80;
                break;
            case 9:
                num = 90;
                break;
            case 10:
                num = 100;
                break;
        }
        return num;
    }

}
