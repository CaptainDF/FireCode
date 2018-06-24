package com.baidu.sdk;

import com.baidu.aip.face.AipFace;
import com.baidu.utils.Base64Util;
import com.baidu.utils.FileUtil;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FaceTest {
    //设置APPID/AK/SK
    public static final String APP_ID = "11425254";
    public static final String API_KEY = "xahfLCSL6P59BcOVZOIbG679";
    public static final String SECRET_KEY = "HBPQdmh7Ir7thUijIdQ4Y4fgvei9frtS";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "WechatIMG74.jpeg";
        String encode = "";
        try {
            encode = Base64Util.encode(FileUtil.readFileByBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,String> param = new HashMap<String,String>();
        //param.put("image_type","FACE_TOKEN");
        //param.put("image","6746c4b7d6f634144814a531873c86dc");
        param.put("face_field","age,beauty,faceshape,gender,glasses,landmark,race,quality,facetype");
        param.put("face_type","LIVE");
        JSONObject res = client.detect(encode, "BASE64",param);
        System.out.println(res.toString(2));

    }
}
