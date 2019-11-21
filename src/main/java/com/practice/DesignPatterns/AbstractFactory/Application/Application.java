package com.practice.DesignPatterns.AbstractFactory.Application;

import com.practice.DesignPatterns.AbstractFactory.Button.Button;
import com.practice.DesignPatterns.AbstractFactory.CheckBox.CheckBox;
import com.practice.DesignPatterns.AbstractFactory.Factory.GuiFactory;

public class Application {

    private GuiFactory guiFactory;
    private Button button;
    private CheckBox checkBox;

    public Application(GuiFactory guiFactory) {
        this.guiFactory = guiFactory;

    }

    public void createButton(){
        this.button = guiFactory.createButton();
    }

    public void createCheckBox(){
        this.checkBox = guiFactory.createCheckBox();
    }

    public void renderButton(){
        button.render();
    }

    public void renderCheckBox() {
        checkBox.render();
    }

}
