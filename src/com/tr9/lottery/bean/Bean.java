package com.tr9.lottery.bean;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 13:30
 */
@Data
public class Bean {
    //期号
//    private String issue;
    private SimpleStringProperty issue = new SimpleStringProperty();
    //开奖号码
//    private String openNumber;
    private SimpleStringProperty openNumber = new SimpleStringProperty();
    //第一位
//    private String numOne;
    private SimpleStringProperty numOne = new SimpleStringProperty();
    //第二位
//    private String numTwo;
    private SimpleStringProperty numTwo = new SimpleStringProperty();
    //第三位
//    private String numThree;
    private SimpleStringProperty numThree = new SimpleStringProperty();
    //和值
//    private String sumValue;
    private SimpleStringProperty sumValue = new SimpleStringProperty();
    //大小
//    private String numSize;
    private SimpleStringProperty numSize = new SimpleStringProperty();
    //单双
//    private String singleOrDouble;
    private SimpleStringProperty singleOrDouble = new SimpleStringProperty();
    //三同
//    private boolean similarities;
    private SimpleBooleanProperty similarities = new SimpleBooleanProperty();

    public String getIssue() {
        return issue.get();
    }

    public SimpleStringProperty issueProperty() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue.set(issue);
    }

    public String getOpenNumber() {
        return openNumber.get();
    }

    public SimpleStringProperty openNumberProperty() {
        return openNumber;
    }

    public void setOpenNumber(String openNumber) {
        this.openNumber.set(openNumber);
    }

    public String getNumOne() {
        return numOne.get();
    }

    public SimpleStringProperty numOneProperty() {
        return numOne;
    }

    public void setNumOne(String numOne) {
        this.numOne.set(numOne);
    }

    public String getNumTwo() {
        return numTwo.get();
    }

    public SimpleStringProperty numTwoProperty() {
        return numTwo;
    }

    public void setNumTwo(String numTwo) {
        this.numTwo.set(numTwo);
    }

    public String getNumThree() {
        return numThree.get();
    }

    public SimpleStringProperty numThreeProperty() {
        return numThree;
    }

    public void setNumThree(String numThree) {
        this.numThree.set(numThree);
    }

    public String getSumValue() {
        return sumValue.get();
    }

    public SimpleStringProperty sumValueProperty() {
        return sumValue;
    }

    public void setSumValue(String sumValue) {
        this.sumValue.set(sumValue);
    }

    public String getNumSize() {
        return numSize.get();
    }

    public SimpleStringProperty numSizeProperty() {
        return numSize;
    }

    public void setNumSize(String numSize) {
        this.numSize.set(numSize);
    }

    public String getSingleOrDouble() {
        return singleOrDouble.get();
    }

    public SimpleStringProperty singleOrDoubleProperty() {
        return singleOrDouble;
    }

    public void setSingleOrDouble(String singleOrDouble) {
        this.singleOrDouble.set(singleOrDouble);
    }

    public boolean isSimilarities() {
        return similarities.get();
    }

    public SimpleBooleanProperty similaritiesProperty() {
        return similarities;
    }

    public void setSimilarities(boolean similarities) {
        this.similarities.set(similarities);
    }
}
