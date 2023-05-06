package com.fanta.book.springboot.web.dto;

import com.fanta.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//추가와 등록을 위한 Posts의 정보를 담는 Dto
//Entity클래스에서 id 자동생성하는 annotaion @Id @@GeneratedValue(strategy= GenerationType.IDENTITY)사용
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder //id는 자동생성되므로, 생성자에서 3개만 받음
    public PostsSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Posts toEntity(){
        //Dto를 활용해서 Posts 인스턴스 생성할 수 있음
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
