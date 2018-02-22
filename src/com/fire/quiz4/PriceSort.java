package com.fire.quiz4;

import org.junit.Test;

import java.io.*;
import java.util.Set;
import java.util.TreeMap;

public class PriceSort {

    @Test
    public void proceSort() throws IOException{
        //读文件
        InputStream is = new FileInputStream("products.txt");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));
        String line;
        TreeMap sortedProduct = new TreeMap<Integer,String>();
        while(reader.ready()){
            line = reader.readLine();
            //System.out.println(line);
            String[] s = line.split(",");
            sortedProduct.put(s[1],s[0]);
        }
        reader.close();
        is.close();

        //写文件
        FileWriter fw =  new FileWriter("Sorted.txt");
        BufferedWriter bufw = new BufferedWriter(fw);

        //遍历排序后的map
        Set treeSet = sortedProduct.keySet();
        for(Object i:treeSet){
            bufw.write(sortedProduct.get(i)+","+i);
            bufw.newLine();
            //System.out.println("key="+i+",,,value="+sortedProduct.get(i));
        }
        bufw.flush();
        bufw.close();
        fw.close();
    }
}
