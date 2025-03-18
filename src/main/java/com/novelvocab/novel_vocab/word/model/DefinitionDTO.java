package com.novelvocab.novel_vocab.word.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefinitionDTO {

    // 단어 no
    private int wordNo;

    // 뜻
    private String definition;

    // 예문
    private String example;

    // 동의어
    private String synonyms;

    // 반의어
    private String antonyms;
}
