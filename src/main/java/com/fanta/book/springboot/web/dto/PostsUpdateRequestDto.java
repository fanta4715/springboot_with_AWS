package com.fanta.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//수정을 위한 Posts의 정보를 담는 Dto
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    //수정은 제목과 내용만 가능하므로, 2개의 정보를 지니는 Dto
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title=title;
        this.content=content;

    }
}
