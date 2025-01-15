package com.group.libraryapp

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * - 필수 5개 어노테이션
 * 1. @Test => 테스트 메소드를 지정한다. 테스트 메소드를 실행하는 과정에서 오류가 없으면 성공.
 * 2. @BeforeEach => 각 테스트 메소드가 수행되기 전에 실행되는 메소드를 지정한다.
 * 3. @AfterEach => 각 테스트가 수행된 후에 실행되는 메소드를 지정한다.
 * 4. @BeforeAll => 모든 테스트를 수행하기 전에 최초 1회 수행되는 메소드를 지정한다.
 * 5. @AfterAll => 모든 테스트를 수행한 후 최후 1회 수행되는 메소드를 지정한다.
 *
 */
class JunitTest {

  companion object {
    @JvmStatic
    @BeforeAll
    fun beforeAll() {
      println("모든 테스트 시작 전")
    }

    @JvmStatic
    @AfterAll
    fun afterAll() {
      println("모든 테스트 종료 후")
    }
  }

  @BeforeEach
  fun beforeEach() {
    println("각 테스트 시작 전")
  }

  @AfterEach
  fun afterEach() {
    println("각 테스트 종료 후")
  }

  @Test
  fun test1() {
    println("테스트 1")
  }

  @Test
  fun test2() {
    println("테스트 2")
  }

}