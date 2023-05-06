package com.fanta.book.springboot.service.posts;

import com.fanta.book.springboot.domain.posts.Posts;
import com.fanta.book.springboot.domain.posts.PostsRepository;
import com.fanta.book.springboot.web.dto.PostsResponseDto;
import com.fanta.book.springboot.web.dto.PostsSaveRequestDto;
import com.fanta.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* 서비스에서는 비즈니스 로직을 처리하는 것이 아니다
* 트랜잭션, 도메인 간 순서 보장의 역할만 한다
*
* */
@RequiredArgsConstructor //생성자를 통해 의존성 주입함
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //service layer에서 Transactional이 사용돼야 한다
    //추가 등록
    //추가 등록에 필요한 데이터를 가지는 Dto를 활용해서 등록진행
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //수정
    //수정에 필요한 데이터를 가지는 Dto를 활용해서 수정을 진행
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    //조회 요청
    //id를 통해서 찾은 Posts 인스턴스의 데이터를 가지는 Dto 생성 반환
    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity); // entity객체를 반환하는게 아니라, entity랑 똑같은 PostResponseDto 객체를 반환해줌

    }

}
