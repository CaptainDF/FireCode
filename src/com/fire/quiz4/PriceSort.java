package com.fire.quiz4;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class PriceSort {

    @Test
    public void proceSort() throws IOException{
        //读文件
        InputStream is = new FileInputStream("products.txt");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));
        String line;
        Map sortedProduct = new HashMap<String,Integer>();
        while(reader.ready()){
            line = reader.readLine();
            //System.out.println(line);
            String[] s = line.split(",");
            sortedProduct.put(s[0],s[1]);
        }
        reader.close();
        is.close();

        //写文件
        FileWriter fw =  new FileWriter("Sorted.txt");
        BufferedWriter bufw = new BufferedWriter(fw);

        List<Map.Entry<String, Integer>> list1 = new ArrayList<Map.Entry<String, Integer>>(sortedProduct.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int value1 = Integer.parseInt(o1.getValue()+"");
//                System.out.println(value1);
                int value2 = Integer.parseInt(o2.getValue()+"");
                if(value1>value2){
                    return 1;
                }
                if(value1<value2){
                    return -1;
                }
                return 0;
            }
        });


        //遍历排序后的list1
        //Set treeSet = sortedProduct.keySet();
        for(Map.Entry<String, Integer> entry : list1){
            bufw.write(entry.getKey()+","+entry.getValue());
            bufw.newLine();
            //System.out.println("key="+i+",,,value="+sortedProduct.get(i));
        }
        bufw.flush();
        bufw.close();
        fw.close();
    }
}
