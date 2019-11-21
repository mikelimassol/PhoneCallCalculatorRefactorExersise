package com.practice.DesignPatterns.AbstractFactory.Factory;

import com.practice.DesignPatterns.AbstractFactory.Button.Button;
import com.practice.DesignPatterns.AbstractFactory.Button.HtmlButton;
import com.practice.DesignPatterns.AbstractFactory.CheckBox.CheckBox;
import com.practice.DesignPatterns.AbstractFactory.CheckBox.HtmlCheckBox;

public class WebFactory implements GuiFactory {


    public Button createButton() {
        return new HtmlButton();
    }

    public CheckBox createCheckBox() {
        return new HtmlCheckBox();
    }
}
