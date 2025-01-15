package com.group.libraryapp.calculator

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


/**
 * - assertThrows<> => 원하는 Exception 이 발생했는지
 * - assertThat() => 확인하고 싶은 값
 *
 * assertThat() 에서 자주 사용하는 단언문
 *  .isEqualTo() => 기대값
 *  .isTrue, .isFalse => true/false 확인
 *  확인하고 싶은 값이 컬렉션일 시
 *    .hasSize() => 기대하는 사이즈값
 *    .extracting() => 원하는 프로퍼티(키값)
 *      .containsExactly() => 프로퍼티의 값(value) 존재 여부(순서 상관없이 있는지 확인)
 *
 */
class JunitCalculatorTest {

  @Test
  fun addTest() {
    // given
    val calculator = Calculator(5)

    // when
    calculator.add(3)

    // then
    assertThat(calculator.number).isEqualTo(8)
  }

  @Test
  fun minusTest() {
    // given
    val calculator = Calculator(5)

    // when
    calculator.minus(3)

    // then
    assertThat(calculator.number).isEqualTo(2)
  }

  @Test
  fun multiplyTest() {
    // given
    val calculator = Calculator(5)

    // when
    calculator.multiply(3)

    // then
    assertThat(calculator.number).isEqualTo(15)
  }

  @Test
  fun divideTest() {
    // given
    val calculator = Calculator(5)

    // when
    calculator.divide(2)

    // then
    assertThat(calculator.number).isEqualTo(2)
  }

  @Test
  fun divideExceptionTest() {
    // given
    val calculator = Calculator(5)

    // when & then
    assertThrows<IllegalArgumentException> {
      calculator.divide(0)
    }.apply {
      assertThat(message).isEqualTo("0으로 나눌수 없습니다.")
    }
  }
}