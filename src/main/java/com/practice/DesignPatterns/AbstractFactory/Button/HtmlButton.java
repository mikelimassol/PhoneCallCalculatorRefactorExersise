package com.practice.DesignPatterns.AbstractFactory.Button;

public class HtmlButton implements Button
{
    @Override
    public void render() {

        System.out.println("Rendering Html Button");
        onClick();
    }

    @Override
    public void onClick() {

        System.out.println("Html Button click event");

    }
}
