package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus

class UserLoanHistoryResponse(
  val name: String,
  val books: List<BookHistoryResponse>
) {

  companion object {
    fun of(user: User): UserLoanHistoryResponse {
      return UserLoanHistoryResponse(
        name = user.name,
        books = user.userLoanHistories.map { BookHistoryResponse.of(it) }
      )
    }
  }

}