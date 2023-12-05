package com.waterfox.santabot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main
{
    public static void main(String[] args) throws URISyntaxException, IOException, ParseException
    {
        Bot bot = new Bot();
        bot.createBot(args);
    }
}