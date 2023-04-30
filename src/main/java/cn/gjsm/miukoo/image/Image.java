package cn.gjsm.miukoo.image;

import cn.gjsm.miukoo.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.Map;

public class Image {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://api.openai.com/v1/images/generations")
                .header("Authorization", "Bearer " + Constants.OPENAPI_TOKEN)
                .header("Content-Type","application/json")
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .requestBody(
                        "{" +
                                "\"prompt\":\"性感美女\"," +
                                "\"n\":1," +
                                "\"size\":\"1024x1024\"," +
                                "\"response_format\":\"url\"" +
                            "}"
                )
                .post();
        JSONObject jsonObject = JSON.parseObject(document.body().text());
        JSONArray data = jsonObject.getJSONArray("data");
        for (int i = 0; i < data.size(); i++) {
            JSONObject temp = data.getJSONObject(i);
            System.out.println(temp.get("url"));
        }
    }
}
