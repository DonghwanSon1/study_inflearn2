package com.group.libraryapp.repository.user.loanhistory

import com.group.libraryapp.domain.book.QBook.book
import com.group.libraryapp.domain.user.loanhistory.QUserLoanHistory.userLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class UserLoanHistoryCustomRepositoryImpl(
  private val queryFactory: JPAQueryFactory,
) {
  fun find(bookName: String, status: UserLoanStatus? = null): UserLoanHistory? {
    return queryFactory
      .select(userLoanHistory)
      .from(userLoanHistory)
      .where(
        userLoanHistory.bookName.eq(bookName),
        status?.let { userLoanHistory.status.eq(status) }
      )
      .limit(1)
      .fetchOne()
  }

  fun count(status: UserLoanStatus): Long {
    return queryFactory
      .select(userLoanHistory.id.count())
      .from(userLoanHistory)
      .where(
        userLoanHistory.status.eq(status)
      )
      .fetchOne() ?: 0L
  }
}