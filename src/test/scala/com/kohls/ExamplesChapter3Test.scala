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

  test("Test Map") {
    val input = List(1.0, 2.0, 3.0)
    val result = List.map(input)(_ * -1)
    assert(result === List(-1.0, -2.0, -3.0))
  }

  test("Test  FoldLeft") {
    val input = List(1.0, 2.0, 3.0)
    val result = List.foldLeft(input, -1.0)((x, y) => x * y)
    assert(result === -6.0)
  }

  test("Test Fold Right") {
    val input = List(1.0, 2.0, 3.0)
    val result = List.foldRight(input, -1.0)((a, l) => a * l)
    assert(result === -6.0)

  }

}
