package com.practice.DesignPatterns.AbstractFactory.Application;

import com.practice.DesignPatterns.AbstractFactory.Factory.GuiFactory;
import com.practice.DesignPatterns.AbstractFactory.Factory.WebFactory;
import com.practice.DesignPatterns.AbstractFactory.Factory.WindowsFactory;

public class ApplicationConfigurator {


    enum FactoryType {
        WEB(new WebFactory()),
        WINDOWS(new WindowsFactory());

        public GuiFactory guiFactory;


        FactoryType(GuiFactory guiFactory){
            this.guiFactory = guiFactory;
        }

        GuiFactory getGuiFactory(){
            return guiFactory;
        }

    }



    public static void main(String[] args){

        GuiFactory webFactory =  FactoryType.WEB.getGuiFactory();

        Application application = new Application(webFactory);
        application.createButton();
        application.createCheckBox();
        application.renderCheckBox();
        application.renderButton();


        GuiFactory windowsFactory =  FactoryType.WINDOWS.getGuiFactory();

        application = new Application(windowsFactory);
        application.createButton();
        application.createCheckBox();
        application.renderCheckBox();
        application.renderButton();


    }



}
