package com.practice.DesignPatterns.Factory.Button;

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
