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

  test("Test Drop While") {
    val input: List[Int] = List(1, 2, 3, 4, 5, 6)
    val result = List.dropWhile(input)(_ < 4)
    assert(result === List(4, 5, 6))
  }

  test("Test Fold Right") {
    val string = List('a', 'b', 'c')
    val result = List.foldRight(string, "")((a, b) => a + b)
    assert("abc" === result)
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

  test("Test Append") {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val result = List.append(list1, list2)
    assert(result === List(1, 2, 3, 4, 5, 6))
  }

  test("Test FlatMap") {
    val input = List(List(1, 2), List(3, 4))
    val result = List.flatMap(input)(a => List.map(a)(_ * 2))
    println(result)
  }

}
