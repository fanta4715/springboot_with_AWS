package com.fanta.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
/*<Posts,Long> : <Entity 클래스, PK타입>
JpaRepository를 상속하는 것 만으로 기본적인 CRUD메소드 생성
 Entity클래스와 Entity Repository는 함께 위치해야 함 (도메인 패키지에서 함께 관리)
 */
}

