package com.tr9.lottery.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/9 21:21
 */
public class AnalyzeFrame extends Application {

    private AnalyzeFrame(){

    }

    private static  AnalyzeFrame analyzeFrame = new AnalyzeFrame();

    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("AnalyzeFrame.fxml"));
        primaryStage.setTitle("58彩票大发三分析工具");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static AnalyzeFrame getInstance(){
        return analyzeFrame;
    }
}
