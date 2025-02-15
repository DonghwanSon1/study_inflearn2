package com.group.libraryapp.domain.user

interface UserCustomRepository {
  fun findAllWithHistories(): List<User>
}