package com.fire.quiz2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by DZA on 2018/2/10.
 */
public class KeyMonitor extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_LEFT :
                System.out.println("按下了左方向键");
                break;
            case KeyEvent.VK_UP :
                //do something
                break;
            case KeyEvent.VK_DOWN :
                //do something
                break;
            case KeyEvent.VK_RIGHT:
                //do something
                break;
        }
    }
}
