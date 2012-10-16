package com.kohls

import org.scalatest.FunSuite
import com.kohls.ExamplesChapter3._

/**
 * @author Muhammad Ashraf
 * @since 10/16/12
 */
class ExamplesChapter3Test extends FunSuite {

  test("Test Sum") {
    val input: List[Int] = List(1, 2, 3)
    val sum: Int = List.sum(input)
    assert(sum === 6)
  }

  test("Test Product") {
    val input = List(1.0, 2.0, 3.0)
    val product = List.product(input)
    assert(product === 6)
  }

  test("Test Tail") {
    val input = List(1.0, 2.0, 3.0)
    val result = List.tail(input)
    assert(result === List(2.0, 3.0))
  }

}