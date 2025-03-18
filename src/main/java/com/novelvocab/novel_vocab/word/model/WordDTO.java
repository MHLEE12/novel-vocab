package com.novelvocab.novel_vocab.word.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDTO {

    // 단어 no
    private int wordNo;

    // 단어
    private String word;

    // 품사
    private String partOfSpeech;

    // 동의어
    private String synonyms;

    // 반의어
    private String antonyms;

    // 위키로 가는 url
    private String sourceUrls;
}
