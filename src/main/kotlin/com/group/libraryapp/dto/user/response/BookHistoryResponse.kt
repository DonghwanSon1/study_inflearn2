package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus

class BookHistoryResponse(
  val name: String,
  val isReturn: Boolean
) {

  companion object {
    fun of(history: UserLoanHistory): BookHistoryResponse {
      return BookHistoryResponse(
        name = history.bookName,
        isReturn = history.isReturn
      )
    }
  }
}