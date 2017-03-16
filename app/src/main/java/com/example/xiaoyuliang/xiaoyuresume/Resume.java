package com.example.xiaoyuliang.xiaoyuresume;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xiaoyuliang on 3/12/17.
 */
public class Resume {
    private static ArrayList<HashMap<String, String>> result = new ArrayList<>();

    public static ArrayList<HashMap<String, String>> getResumeFromFile(String s, Context context) {
        try {
            // Load data
            String jsonString = loadJsonFromAsset("resume.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONObject resume = json.getJSONObject("resume");

            // Home page
            JSONObject home = resume.getJSONObject("home page");
            String name = home.getString("name");
            String avatar = home.getString("avatar");
            JSONObject intro = home.getJSONObject("intro");
            String title = intro.getString("title");
            String content = intro.getString("content");
            HashMap<String, String> map = new HashMap<>();
            map.put("name", name);
            map.put("avatar", avatar);
            map.put("title", title);
            map.put("content", content);
            result.add(map);

            //navHeader
            JSONObject navHeader = resume.getJSONObject("navHeader");
            String background = navHeader.getString("background");
            String writer = navHeader.getString("writer");
            String web = navHeader.getString("web");
            HashMap<String, String> map2 = new HashMap<>();
            map2.put("background", background);
            map2.put("writer", writer);
            map2.put("web", web);
            result.add(map2);

            //pages
            JSONArray pages = resume.getJSONArray("page");
            for (int i = 0; i < pages.length(); i++) {
                JSONObject c = pages.getJSONObject(i);
                String page = c.getString("page");
                String url = c.getString("url");
                String detail = c.getString("detail");
                HashMap<String, String> map3 = new HashMap<>();
                map3.put("page", page);
                map3.put("url", url);
                map3.put("detail", detail);
                result.add(map3);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static String loadJsonFromAsset(String filename, Context context){
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }


}
