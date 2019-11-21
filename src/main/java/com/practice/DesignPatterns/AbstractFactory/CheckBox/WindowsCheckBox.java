package com.practice.DesignPatterns.AbstractFactory.CheckBox;

public class WindowsCheckBox implements CheckBox {


    @Override
    public void render() {

        System.out.println("Rendering Windows CheckBox");
        onCheck();

    }

    @Override
    public void onCheck() {

        System.out.println("Windows Checkbox click event");

    }

}
