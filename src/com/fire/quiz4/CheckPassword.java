package com.fire.quiz4;

import javax.swing.*;

public class CheckPassword {

    public static boolean checkPsw(String s){
        char character ;
        int cLetter = 0;
        int cDigit = 0;
        int cSpecial = 0;
        //判断密码位数
        if (s.length()<=7){
            return false;
        }
        for(int i = 0; i<s.length();i++){
            character=s.charAt(i);
            if (Character.isLetter(character)==true){
                cLetter++;
            } else if (Character.isDigit(character)==true) {
                cDigit++;
            } else if (character=='%'||character=='&'||character=='#'){
                cSpecial++;
            }
        }
        //判断字符的个数
        if(cLetter<2){
            return false;
        }
        //判断是否有其他特殊符号
        if((cLetter+cDigit+cSpecial)!=s.length()){
            return false;
        }
        //所有条件都通过,返回true
        return true;
    }

    public static void main(String[]args)
    {
        String password = JOptionPane.showInputDialog("enter your password");
        //isValidPassword(password);
        checkPsw(password);

    }
}
