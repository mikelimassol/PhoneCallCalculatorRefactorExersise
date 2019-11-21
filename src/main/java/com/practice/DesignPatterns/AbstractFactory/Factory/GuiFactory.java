package com.practice.DesignPatterns.AbstractFactory.Factory;

import com.practice.DesignPatterns.AbstractFactory.CheckBox.CheckBox;
import com.practice.DesignPatterns.AbstractFactory.Button.Button;

public interface GuiFactory {

    Button createButton();

    CheckBox createCheckBox();


}
