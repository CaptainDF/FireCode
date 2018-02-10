package com.fire.quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /*
    不同等级对应不同税率
    Data Dictionary
    */

    private static Map dicMap = new HashMap(16);
    private static int[] single = {0,8350,33950,82250,171550,372950};
    private static int[] married = {0,16700,67900,137050,208850,372950};
    private static int[] separately = {0,8350,33950,68525,104425,186476};
    private static int[] houseHold = {0,11950,45500,117450,190200,372950};
    private static float[] taxRate = {0.1f,0.15f,0.25f,0.28f,0.33f,0.35f};

    public static void main(String[] args) {

        //数据字典装入map集合
        dicMap.put(0,single);
        dicMap.put(1,married);
        dicMap.put(2,separately);
        dicMap.put(3,houseHold);
        dicMap.put("taxRate",taxRate);

        int count = 0;
        Scanner xx = new Scanner( System.in );
        System.out.println("Please type the number of person you want to compute the tax");
        String instru = xx.next();

        while(!isNumber(instru)){
            System.out.println("You are not type a number, please type again!");
            instru = xx.next();
        }
        count = Integer.parseInt(instru);

        for(int i = 1; i<(count+1);i++ ){
            System.out.println("Count : "+i+", Totle : "+count);
            System.out.println("The filing status : 1 for Single, 2 for Married Filing Jointly or Qualified Widow(er), 3 for Married Filing Separately, 4 for Head of Household");
            System.out.print("Enter the filing status: ");
            String fil = xx.next();
            while(!checkFiling(fil)){
                System.out.println("The filing you type is invalid, please type again!");
                System.out.print("Enter the filing status: ");
                fil = xx.next();
            }
            int filing = Integer.parseInt(fil);

            System.out.print("Enter the taxable income: ");
            String inc = xx.next();
            while (!isNumber(inc)){
                System.out.println("The filing you type is invalid, please type again!");
                System.out.print("Enter the taxable income: ");
                inc = xx.next();
            }
            int income = Integer.parseInt(inc);

            //computing
            float sum = getTax(filing,income,dicMap);
            System.out.println("Tax is "+sum);
        }
    }

    public static Float getTax(int filing, int income, Map dicMap){
        int[] data = (int[]) dicMap.get(filing);
        float[] taxRate = (float[]) dicMap.get("taxRate");
        Float sum = 0.0F;
        int flag = 6;
        for(int i=0;i<6;i++){
            if(data[i]>income){
                flag=i;
                break;
            }
        }
        //定义税务级别
        //System.out.println("flag="+flag);
        for(int i = 0;i<flag;i++){
            if(flag==i+1){
                sum = sum + (income-data[i])*taxRate[i];
            }else {
                sum = sum + (data[i+1]-data[i])*taxRate[i];
            }
        }
        return sum;
    }

    public static Boolean isNumber(String instru){
        try{
            Integer.parseInt(instru);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static Boolean checkFiling(String filing){
        try{
            int fil = Integer.parseInt(filing);
            if(fil<0 || fil>3){
                return false;
            }
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
