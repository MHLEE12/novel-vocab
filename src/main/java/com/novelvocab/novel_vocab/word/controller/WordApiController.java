package com.novelvocab.novel_vocab.word.controller;

import com.novelvocab.novel_vocab.word.service.WordApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class WordApiController {

    private final WordApiService wordApiService;

    @Autowired
    public WordApiController(WordApiService wordApiService) {
        this.wordApiService = wordApiService;
    }

    @GetMapping
    public ResponseEntity<?> searchWord(@RequestParam(required = true) String word) {
        System.out.println("controller: " + word);

        // TODO 응답 데이터 받는 객체 생성
        String response = wordApiService.getWordDefinition(word);

        // json 형식의 응답값 받음
        return ResponseEntity.ok(response);
    }
}
