package com.practice.DesignPatterns.Factory.Application;

import com.practice.DesignPatterns.Factory.Factory.Dialog;
import com.practice.DesignPatterns.Factory.Factory.WebDialog;
import com.practice.DesignPatterns.Factory.Factory.WindowsDialog;

public class ClientApplicationWithEnum {

    enum DialogType {

        WEB(new WebDialog()), WINDOWS(new WindowsDialog());


        private Dialog dialog;


        DialogType(Dialog dialog){

            this.dialog = dialog;

        }

        public Dialog getDialog(){
            return dialog;
        }

        public void renderWindow() {
            dialog.renderWindow();
        }

    }


    public static void main(String[] args){

        DialogType.WEB.renderWindow();
        DialogType.WINDOWS.renderWindow();

    }
}
