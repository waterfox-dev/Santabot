package com.waterfox.santabot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class JsonUtil
{
    public static JSONObject load()
    {
        Path filePath = Paths.get("src/main/resources/users.json");

        if (Files.exists(filePath))
        {
            try
            {
                String content = Files.readString(filePath);

                JSONParser jsonParser = new JSONParser();
                return (JSONObject) jsonParser.parse(content);
            } catch (IOException | ParseException e)
            {
                throw new RuntimeException(e);
            }

        }
        else
        {
            return null;
        }
    }

    public static void write(JSONObject o)
    {
        Path filePath = Paths.get("src/main/resources/users.json");

        if (Files.exists(filePath))
        {
            try
            {
                FileWriter fw = new FileWriter(String.valueOf(filePath));
                fw.write(o.toJSONString());
                fw.flush();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }

        }
    }

    public static void addUser(long id)
    {
        JSONObject d = JsonUtil.load();
        assert d != null;
        if(!d.containsKey(String.valueOf(id)))
        {
            JSONObject uObject = new JSONObject();
            uObject.put("message", "");
            uObject.put("target", "");
            uObject.put("file", "");
            d.put(id, uObject);
        }
        JsonUtil.write(d);
    }

    public static void distribute()
    {
        JSONObject d = JsonUtil.load();
        assert d != null;
        Random random = new java.util.Random();
        List choiceUser = new java.util.ArrayList(d.keySet().stream().toList());
        List browseUser = d.keySet().stream().toList();
        for(Object s : browseUser)
        {
            s = (String) s;
            boolean success = false;
            int rdmValue = 0;
            while(!success)
            {
                rdmValue = random.nextInt(choiceUser.size());
                if(choiceUser.get(rdmValue) != s)
                {
                    success = true;
                }
            }
            JSONObject userData = (JSONObject) d.get(s);
            userData.put("target", choiceUser.get(rdmValue));
            choiceUser.remove(rdmValue);
        }
        JsonUtil.write(d);
    }

    public static long getSecret(long id)
    {
        JSONObject d = JsonUtil.load();
        JSONObject t = (JSONObject) d.get(String.valueOf(id));
        return Long.parseLong((String) t.get("target"));
    }

    public static void writeMessage(long id, String content)
    {
        JSONObject d = JsonUtil.load();
        JSONObject t = (JSONObject) d.get(String.valueOf(id));
        t.put("message", content);
        JsonUtil.write(d);
    }

    public static void writeFile(long id, String url)
    {
        JSONObject d = JsonUtil.load();
        JSONObject t = (JSONObject) d.get(String.valueOf(id));
        t.put("file", url);
        JsonUtil.write(d);
    }
}
