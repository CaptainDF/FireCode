//package com.show;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Iterator;
//
//import com.sun.org.apache.xpath.internal.operations.Bool;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//
//import javax.sound.midi.SoundbankResource;
//
///**
// * Created by DZA on 2018/4/18.
// */
//public class GetPhone {
//
//    @Test
//    public void test2(){
//        String fileName = "C:\\Users\\Captain\\Desktop\\mobile_num.xlsx";
//
//        String target = "C:\\Users\\Captain\\Desktop\\mobile_num_done.xlsx";
//        try {
//            InputStream input = new FileInputStream(fileName);  //建立输入流
//
//            FileOutputStream fileOut = new FileOutputStream(target);
//            Workbook wb  = null;
//            //根据文件格式(2003或者2007)来初始化
//            wb = new XSSFWorkbook(input);
//            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单
//            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
//            while (rows.hasNext()) {
//                Row row = rows.next();  //获得行数据
//                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始
//                //处理第二列
//                Cell cell2 = row.getCell(1);
//                try{
//                    if (cell2!=null){
//                        String value = cell2.getStringCellValue();
//                        //value.replaceAll("[\\t\\n\\r]","");
//                        //value.trim().replace(" ","").replace("-","").replace("+","");
//                        /*for (int i=0;i<value.length()-10;i++){
//                            String s = value.substring(i,i+10);
//                            if (isPhone(s)){
//                                System.out.println(s);
//                            }
//                        }*/
//                        String s = getNumber_charAt(value);
//                        Cell cell7 = row.getCell(7);
//                        if (cell7==null){
//                            cell7 = row.createCell(7);
//                        }
//                        cell7.setCellValue(s);
//
//                        System.out.println(s);
//                    }
//                }catch (IllegalStateException e){
//                    continue;
//                }
//
//            }
//            wb.write(fileOut);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }finally {
//
//        }
//    }
//
//    public String getNumber_charAt(String STR){
//        StringBuffer sBuffer = new StringBuffer();
//        for (int i = 0; i < STR.length(); i++) {
//            char ch = STR.charAt(i);
//            if(48<=ch&&ch<=57){
//                sBuffer.append(ch);
//            }
//        }
//        return sBuffer.toString();
//    }
//
//    private Boolean isPhone(String s ){
//        try{
//            Integer.parseInt(s);
//            return true;
//        }catch (NumberFormatException e){
//            return false;
//        }
//    }
//
//    @Test
//    public void test(){
//        String fileName = "C:\\Users\\Captain\\Desktop\\mobile_num.xlsx";
//
//
//        readContent(fileName);
//    }
//
//    /**
//     * 从excel读取内容
//     */
//    private static void readContent(final String fileName) {
//        boolean isE2007 = false;    //判断是否是excel2007格式
//        if (fileName.endsWith("xlsx")) {
//            isE2007 = true;
//        }
//        try {
//            InputStream input = new FileInputStream(fileName);  //建立输入流
//            Workbook wb  = null;
//            //根据文件格式(2003或者2007)来初始化
//            if (isE2007) {
//                wb = new XSSFWorkbook(input);
//            } else {
//                wb = new HSSFWorkbook(input);
//            }
//            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单
//            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
//            while (rows.hasNext()) {
//                Row row = rows.next();  //获得行数据
//                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始
//                Cell cell2 = row.getCell(1);
//                if (cell2!=null){
//                    String value = cell2.getStringCellValue();
//                    System.out.println(value);
//                }
//
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
