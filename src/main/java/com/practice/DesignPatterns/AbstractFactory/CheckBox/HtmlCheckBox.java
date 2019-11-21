package com.practice.DesignPatterns.AbstractFactory.CheckBox;

public class HtmlCheckBox implements CheckBox
{
    @Override
    public void render() {

        System.out.println("Rendering Html CheckBox");
        onCheck();
    }

    @Override
    public void onCheck() {

        System.out.println("Html CheckBox click event");

    }
}
