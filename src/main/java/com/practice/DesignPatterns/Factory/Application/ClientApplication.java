package com.practice.DesignPatterns.Factory.Application;

import com.practice.DesignPatterns.Factory.Factory.Dialog;
import com.practice.DesignPatterns.Factory.Factory.WebDialog;
import com.practice.DesignPatterns.Factory.Factory.WindowsDialog;

public class ClientApplication {

    enum DialogType {
        WEB, WINDOWS;

    }

    private Dialog dialog;

    public ClientApplication(DialogType type) {


        switch(type){

            case WEB:
                dialog = new WebDialog();
                break;
            case WINDOWS:
                dialog = new WindowsDialog();
                break;
        }

    }

    public void renderWindow() {
         dialog.renderWindow();
    }


    public static void main(String[] args){


        ClientApplication webApplication = new ClientApplication(DialogType.WEB);
        webApplication.renderWindow();

        ClientApplication windowApplication = new ClientApplication(DialogType.WINDOWS);
        windowApplication.renderWindow();


    }



}
