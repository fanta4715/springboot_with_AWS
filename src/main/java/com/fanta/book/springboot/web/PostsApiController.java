package com.fanta.book.springboot.web;
import com.fanta.book.springboot.service.posts.PostsService;
import com.fanta.book.springboot.web.dto.PostsResponseDto;
import com.fanta.book.springboot.web.dto.PostsSaveRequestDto;


import com.fanta.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController //리턴에 @ResponseBody를 자동으로 해줌
public class PostsApiController {

    private final PostsService postsService;

    //새로운 포스트 저장
    //추가,등록의 PostMapping
    //추가, 등록한 posts 객체의 id 반환
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    //id에 해당하는 포스트 업데이트
    //수정
    //수정한 posts 객체의 id반환
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);

    }

    //조회, 요청
    //id에 해당하는 Posts Dto를 반환
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

}
