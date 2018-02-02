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

        Scanner xx = new Scanner( System.in );
        System.out.print("Enter the filing status: ");
        int filing = xx.nextInt();
        System.out.print("Enter the taxable income: ");
        int income = xx.nextInt();

        //computing
        float sum = getTax(filing,income,dicMap);
        System.out.println("Tax is "+sum);
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
}
