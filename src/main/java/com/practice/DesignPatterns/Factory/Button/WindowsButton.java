package com.practice.DesignPatterns.Factory.Button;

public class WindowsButton implements Button {


    @Override
    public void render() {

        System.out.println("Rendering Windows Button");
        onClick();

    }

    @Override
    public void onClick() {

        System.out.println("Windows Button click event");

    }

}
