package com.tr9.lottery.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 13:25
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        primaryStage.setTitle("58彩票大发三分析工具");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
