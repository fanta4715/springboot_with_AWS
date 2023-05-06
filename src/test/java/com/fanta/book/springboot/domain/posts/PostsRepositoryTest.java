package com.fanta.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 @RunWith : 스프링 부트 테스트와 JUnit사이의 연결자
 JUnit : 단위 테스트 프레임워크, @Test
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    //빈을 주입받는 Autowired
    @Autowired
    PostsRepository postsRepository;

    //@After : 단위 테스트가 끝날 때마다 수행되는 메소드
    //테스트간 데이터 충돌 방지를 위해 사용
    @After
    public void cleanup(){
        //JPArepository를 상속했더니, deleteAll()메소드 생성되었다.
        postsRepository.deleteAll();
    }

    //Repository가 CRUD함수를 잘 생성했는 지 확인하기 위함
    @Test
    public void 게시글저장_불러오기(){
        //given
        String title="테슽트 게시글";
        String content="테스트 본문";

        //JpaRepository의 상속으로, 구현하지 않은 save함수 사용가능
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("fanta4715@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts=postsList.get(0);
        // asserThat : assertj 테스트 검증 라이브러리의 검증 메소드
        // isEqualTo : assertj의 동등 비교 메소드
        //저장해서 꺼낸 Posts객체가 우리가 넣은 값인지 확인
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){

        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createDate="+posts.
                getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        //자동으로 생성된 column인 생성시간과 수정시간이
        //now 이후에 발생했는지 확인
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }


}
