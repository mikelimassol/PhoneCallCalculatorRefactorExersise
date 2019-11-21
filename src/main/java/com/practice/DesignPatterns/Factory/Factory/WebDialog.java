package com.practice.DesignPatterns.Factory.Factory;

import com.practice.DesignPatterns.Factory.Button.Button;
import com.practice.DesignPatterns.Factory.Button.HtmlButton;

public class WebDialog extends Dialog {
    @Override
    public Button renderButton() {
        return new HtmlButton();
    }
}
