package com.group.libraryapp.calculator

fun main() {
  val calculatorTest = CalculatorTest()
  calculatorTest.addTest()
  calculatorTest.minusTest()
  calculatorTest.multiplyTest()
  calculatorTest.divideTest()
  calculatorTest.divideExceptionTest()
}

/**
 * 수동으로 만든 테스트 코드 단점
 * 1. 테스트 클래스와 메소드가 생길때마다 메인 메소드에 수동으로 코드를 작성해줘야 하고, 메인 메소드가 커진다.
 *    테스트 메소드를 개별적으로 실행하기도 어러움.
 * 2. 테스트가 실패한 경우 무엇을 기대하였고, 어떤 잘못된 값이 들어와 실패했는지 알려주지 않는다.
 *    또는, Try Catch를 사용해야하는 부분이 많아 불편하다.
 * 3. 공통적으로 처리해야 하는 기능이 있다면, 중복이 생긴다.
 *
 * --> 따라서 JUnit5를 사용하자.
 */
class CalculatorTest {

  fun addTest() {

    // given
    val calculator = Calculator(5)

    // when
    calculator.add(3)

    // then
    if (calculator.number != 8) {
      throw IllegalStateException()
    }
  }

  fun minusTest() {

    // given
    val calculator = Calculator(5)

    // when
    calculator.minus(3)

    // then
    if (calculator.number != 2) {
      throw IllegalStateException()
    }
  }

  fun multiplyTest() {

    // given
    val calculator = Calculator(5)

    // when
    calculator.multiply(3)

    // then
    if (calculator.number != 15) {
      throw IllegalStateException()
    }
  }

  fun divideTest() {

    // given
    val calculator = Calculator(5)

    // when
    calculator.divide(2)

    // then
    if (calculator.number != 2) {
      throw IllegalStateException()
    }
  }

  fun divideExceptionTest() {

    // given
    val calculator = Calculator(5)

    // when
    try {
      calculator.divide(0)
    } catch (e: IllegalArgumentException) {
      if (e.message != "0으로 나눌수 없습니다.") throw IllegalStateException("메시지가 다릅니다.")
      return
    } catch (e: Exception) {
      throw IllegalStateException()
    }
    throw IllegalStateException("기대한 Exception이 발생하지 않았습니다.")
  }
}