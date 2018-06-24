package com.interviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class interviews {

    @Test
    public void iTest(){
        int i = Integer.MAX_VALUE;
        System.out.println(i);

        System.out.println(i+1);
    }

    @Test
    public void stringTest(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        String s4 = "Program" + new String("ming");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s2.intern());
        System.out.println(s1 == s4);

    }

    @Test
    public void listTest(){
        List list = new ArrayList<>(20);
        Map map = new HashMap<>(20);
    }

    @Test
    public void test(){
        int i = getValue(2);
        System.out.println(i);
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }
}
