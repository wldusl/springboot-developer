package me.gojiyeon.springbootedeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gojiyeon.springbootedeveloper.domain.Article;

@NoArgsConstructor  //기본생성자 추가
@AllArgsConstructor // 모든필드값을 파라미터로 받는 생성자추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(String author){ //생성자 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
