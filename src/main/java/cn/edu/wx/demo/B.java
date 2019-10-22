package cn.edu.wx.demo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.util.JSONBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class B {
    public static void main(String[] args) {
        String charset = "utf-8";
        //1.json字符串转换为对象
        String jsonString = "{'idcard':'42313123','id':'2345'}";
        //2.json字符串转换为map
        @SuppressWarnings("unchecked")
        Map<String, String> map = JSONObject.parseObject(jsonString, Map.class);
        System.out.println(map.get("idcard") + " " + map.get("id")); //输出 42313123 2345
        //3.将对象转换为json字符串


        //4./将String转换成JSONObjct格式
        String str = "{\"result\":\"success\",\"message\":\"成功！\"}";
        JSONObject json;
        json = JSONObject.parseObject(str);
        System.out.println(json); //输出  {"result":"success","message":"成功！"}
        //5.将string转换成JSONArray
        String str1 = "{\"result\":\"success\",\"message\":\"成功！\",\"data\"[{\"name\":\"Tom\",\"age\":\"20\"}]}";
        JSONObject json1;
        json = JSONObject.parseObject(str1);
        System.out.println(json);
        //输出 {"result":"success","data":[{"name":"Tom","age":"20"}],"message":"成功！"}
        JSONArray jsonArray = JSONArray.parseArray(json.getString("data"));
        //输出 [{"name":"Tom","age":"20"}]
        System.out.println(jsonArray.toString());
    }
}
