package com.novelvocab.novel_vocab.word.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

@Service
public class WordApiService {
    public String getWordDefinition(String word) {
        // TODO 응답값 객체로 변환예정
        String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
        String result;

        try {
            URL url  = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "Application/json");

            // HTTP 응답 코드 확인 후 단어 아닌 것들 에러 처리
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("해당 단어를 찾을 수 없습니다. - " + word);

                // TODO 리턴 타입 바꿀 예정!
                return "조회되는 단어 없음";
            }

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(result);
            JSONObject jsonObject = new JSONObject();


            Iterator<?> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                jsonObject = (JSONObject) iterator.next();
            }

            System.out.println("test: " + jsonObject.get("meanings"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
