package com.fanta.book.springboot.web.dto;

import com.fanta.book.springboot.domain.posts.Posts;
import lombok.Getter;

//조회를 위한 Posts의 정보를 담는 Dto
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    //id를 통해서 entity를 찾을 거고(repository의 CRUD함수를 통해서)
    //그 entity를 통해서 PostResponseDto 인스턴스를 반환해줌
    public PostsResponseDto(Posts entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
    }

}
