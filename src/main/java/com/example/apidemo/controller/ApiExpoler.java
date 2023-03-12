package com.example.apidemo.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ApiExpoler {

    @GetMapping("/api")
    public static void main(String[] args) throws IOException {
        // 오픈 API의 요청에 규격에 맞는 파라미터 생성

        String serviceKey = "6c794f7276696f7639306c4e677652"; //인증키
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/"+ serviceKey +"/xml/SeoulPublicLibraryInfo/1/5/");

        //URL 객체 생성
        URL url = new URL(urlBuilder.toString());

        //요청하고자 하는 url과 통신하기 위한 connection 객체 생성
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //통신을 위한 메소드
        con.setRequestMethod("GET");
        //통신을 위한 CONTENT-TYPE SET
        con.setRequestProperty("Content-type", "application/json");
        //통신 응답 코드 확인
        System.out.println("RESPONSE CODE" + con);

        //전달받은 데이터를 BufferedReader
        BufferedReader rd;
        if(con.getResponseCode() >= 200 && con.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        con.disconnect();

        System.out.println(sb.toString());
        
    }
}