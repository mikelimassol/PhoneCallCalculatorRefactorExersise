package com.practice.DesignPatterns.Factory.Factory;

import com.practice.DesignPatterns.Factory.Button.Button;
import com.practice.DesignPatterns.Factory.Button.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button renderButton() {
        return new WindowsButton();
    }

}
