package com.shiftedtech.qa.framework.scriptbase;

/**
 * Created by ShiftTeacher on 2/17/2018.
 */
public class TestStep {

    String step;
    String keyword;
    String page;
    String testObjectName;
    String data;

    public TestStep(String step, String keyword, String page, String testObjectName, String data) {
        this.step = step;
        this.keyword = keyword;
        this.page = page;
        this.testObjectName = testObjectName;
        this.data = data;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTestObjectName() {
        return testObjectName;
    }

    public void setTestObjectName(String testObjectName) {
        this.testObjectName = testObjectName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isMatchingKeyword(String kw){
        if(keyword.equalsIgnoreCase(kw)){
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString() {
        return "TestStep{" +
                "step='" + step + '\'' +
                ", keyword='" + keyword + '\'' +
                ", page='" + page + '\'' +
                ", testObjectName='" + testObjectName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
