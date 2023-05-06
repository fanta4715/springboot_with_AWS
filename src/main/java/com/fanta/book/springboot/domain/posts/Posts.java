package com.fanta.book.springboot.domain.posts;

import com.fanta.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 JPA가 지원하는 어노테이션
 @Entity : 테이블의 저장 단위를 선언, 의미함
 @Id : PK필드를 나타냄(personal key)
 @GeneratedValue : PK의 생성규칙
 @Column : 굳이 선언 안 해도됨(기본값, 추가 변경 옵션 설정가능 ex.문자열사이즈,타입변경)

 @NoArgsConstructor : 기본 생성자 추가
 @Getter : 모든 필드의 getter메소드 자동 생성
 @Builder : 빌더 패턴 클래스 생성, 생성자 위에 사용
* */
@Getter
@NoArgsConstructor //
@Entity //Entity : DB에 저장할 단위를 의미함+ Entity클래스 수정을 통해 DB수정
public class Posts extends BaseTimeEntity {

    @Id //
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length =500, nullable=false)
    private String title;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;
    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    /*setter를 무분별하게 사용하지 않고
    update의 이름을 사용해서 목적과 의도를 드러냄
    set을 하는 경우를 확실히 setter함수에서 보이는 것이 메리트있음
     */
    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
