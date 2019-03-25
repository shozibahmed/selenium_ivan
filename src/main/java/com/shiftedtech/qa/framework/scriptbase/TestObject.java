package com.shiftedtech.qa.framework.scriptbase;

import org.openqa.selenium.By;

/**
 * Created by ShiftTeacher on 2/18/2018.
 */
public class TestObject {
    private String id;
    private String page;
    private String name;
    private String description;
    private String findBy;
    private String using;

    public TestObject(){
    }
    public TestObject(String id, String page, String name, String description, String findBy, String using) {
        this.id = id;
        this.page = page;
        this.name = name;
        this.description = description;
        this.findBy = findBy;
        this.using = using;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFindBy() {
        return findBy;
    }

    public void setFindBy(String findBy) {
        this.findBy = findBy;
    }

    public String getUsing() {
        return using;
    }

    public void setUsing(String using) {
        this.using = using;
    }

    public By by(){
        if (this.findBy.trim().toUpperCase().contentEquals("ID")) {
            return By.id(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("NAME")) {
            return By.name(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("XPATH")) {
            return By.xpath(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("CSS")) {
            return By.cssSelector(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("CLASS_NAME")) {
            return By.className(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("LINK_TEXT")) {
            return By.linkText(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("TAGNAME")) {
            return By.tagName(this.using);
        } else if (this.findBy.trim().toUpperCase().contentEquals("PARTIAL_LINK_TEXT")) {
            return By.partialLinkText(this.using);
        } else {
            return null;
        }
    }


    @Override
    public String toString() {
        return "TestObject{" +
                "id='" + id + '\'' +
                ", page='" + page + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", findBy='" + findBy + '\'' +
                ", using='" + using + '\'' +
                '}';
    }
}
