package com.fanta.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
* BaseTimeEntity클래스는 모든 Entity의 상위 클래스가 된다
* createdDate, modifiedDate를 자동으로 관리
* */
@Getter
@MappedSuperclass //Entity들이 이 클래스를 상속할 경우에 이 클래스의
//필드마저 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //이 클래스에 Auditing기능포함
public class BaseTimeEntity {
    @CreatedDate //Entity생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity값 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;


}
