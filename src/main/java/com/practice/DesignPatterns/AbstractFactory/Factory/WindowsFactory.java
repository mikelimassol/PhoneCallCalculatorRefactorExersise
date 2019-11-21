package com.practice.DesignPatterns.AbstractFactory.Factory;

import com.practice.DesignPatterns.AbstractFactory.Button.Button;
import com.practice.DesignPatterns.AbstractFactory.Button.WindowsButton;
import com.practice.DesignPatterns.AbstractFactory.CheckBox.CheckBox;
import com.practice.DesignPatterns.AbstractFactory.CheckBox.WindowsCheckBox;

public class WindowsFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }

}
