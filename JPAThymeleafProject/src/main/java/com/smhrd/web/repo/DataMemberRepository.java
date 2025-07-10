package com.smhrd.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.web.entity.DataMember;


//JPA 사용시, 대상이 되는 테이블 내부에 PK가 정수 형태라면?
// -> <>: 제네릭기법을 사용하기 때문에, 정수형태도 int의 객체 형태인
//		  wrapper class 형태인 Integer or Long 사용!
@Repository
public interface DataMemberRepository extends JpaRepository<DataMember, String> {

	// Hibernate 구현체를 사용하는 용도로 만든 도구
	
	// hibernate가 메소드명칭 -> sql구문을 제작
	// 기본으로 제공되는 메소드
	// 1. find() >> 조회할 때 사용한다.
	// : SELECT * FROM DATAMEMBER;
	
	// 2. findById() >> PK를 기준으로 조회할 때 사용
	//***** 여러개의 단어를 하나로 작성할 때, 반드시 카멜식 기법을 따라야 한다.
	
	// 3. save(DataMember m)
	// : 데이터를 추가 (insert) / 데이터를 수정(updata)
	// ******* id값을 기준으로 봤을 때, 데이터가 존재하면 update를 수행하고, 존재하지 않다면 insert를 수행한다.
	
	// 4. delete(String id)
	// : 데이터를 삭제할 때 사용(delete 구문 호출)
	
	// 나만의 커스터마이징하는 기능을 만들고 싶다면
	// --> JPA 규칙을 지켜주자
	// find... : select 구문동작 >> ... 컬럼이름들이 들어올수 있음
	// By : 조건을 부여하겠다.(where)
	// 테이블의 컬럼이름들을 카멜식으로 표현 (And, Or, Between a And b 등등)
	// --> 테이블을 
	// ex1)id 와 pw가 일치한 데이터를 조회
	public DataMember findByIdAndPw(String id, String pw);
}
