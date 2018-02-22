package com.fire.quiz4;

import javax.swing.*;

public class CheckPassword {

    public static boolean checkPsw(String s){
        char c ;
        if (s.length()<=7){
            return false;
        }
        for(int i = 0; i<s.length();i++){

        }
        return true;
    }

    public static void main(String[]args)
    {
        String password = JOptionPane.showInputDialog("enter your password");
        //isValidPassword(password);

    }
}
