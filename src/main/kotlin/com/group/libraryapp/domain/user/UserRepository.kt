package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository {

  fun findByName(name: String): User?

  /**
   * JPQL 문제점
   *  1. 문자열이기에 '버그' 찾기가 어렵다.
   *  2. JPQL 문법이 일반 SQL 이랑 조금 달라 복잡한 쿼리를 작성할때 마다 찾아보아야 한다.
   *  3. 조건이 복잡한 동적쿼리를 작성할때 함수가 계속해서 늘어난다.
   *  4. 프로덕션 코드(도메인의 필드) 변경에 취약하다.
   *
   *  따라서 QueryDSL + JPA 를 사용해보자
   */
//  @Query("SELECT DISTINCT u " +
//      "   FROM User u" +
//      "   LEFT JOIN FETCH u.userLoanHistories")
//  fun findAllWithHistories(): List<User>
}