package com.group.libraryapp.utill

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

fun fail(): Nothing {
  throw IllegalStateException()
}

fun <T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T {
  return this.findByIdOrNull(id) ?: fail()
}