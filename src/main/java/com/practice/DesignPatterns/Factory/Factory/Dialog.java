package com.practice.DesignPatterns.Factory.Factory;

import com.practice.DesignPatterns.Factory.Button.Button;

public abstract class Dialog {


    public void renderWindow() {
        Button okButton = renderButton();
        okButton.onClick();
        okButton.render();
    }

    public abstract Button renderButton();


}
