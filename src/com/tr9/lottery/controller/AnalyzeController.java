package com.tr9.lottery.controller;

import com.tr9.lottery.bean.Bean;
import com.tr9.lottery.bean.Calc;
import com.tr9.lottery.manager.Manager;
import com.tr9.lottery.service.Service;
import com.tr9.lottery.service.impl.ServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/9 21:39
 */
public class AnalyzeController implements Initializable {

    private Service service = new ServiceImpl();

    @FXML
    private LineChart lineChart;

    public void initialize(URL location, ResourceBundle resources) {
        lineChart.setTitle("号码走势图");
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        ObservableList<Bean> list = FXCollections.observableList(MainController.list);
        String start = list.get(0).getIssue();
        String end = list.get(list.size() - 1).getIssue();
        series.setName(start + "-" + end + "号码走势图");
        for (Bean bean : list) {
            String str = bean.getIssue().substring(bean.getIssue().length() - 4);
            series.getData().add(new XYChart.Data<>(str, Integer.parseInt(bean.getSumValue())));
        }
        for(XYChart.Data<String,Number> data : series.getData()){
            Node text = new Text(data.getYValue().toString());
            data.setNode(text);
        }
        lineChart.autosize();
        lineChart.setCreateSymbols(true);
        lineChart.getData().add(series);
    }

    @FXML
    public void doResult(){
        List<Calc> list = service.get(MainController.list);
        MainController mainController = (MainController)Manager.context.get("MainController");
        mainController.doResult(list);
        Stage stage = (Stage)Manager.context.get("AnalyzeStage");
        stage.close();
    }
}
