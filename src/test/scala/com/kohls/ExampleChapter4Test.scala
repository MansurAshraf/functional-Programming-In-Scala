package com.kohls

import org.scalatest.FunSuite

import com.kohls.ExampleChapter4._

/**
 *
 * @author Muhammad Ashraf
 * @since 1/10/13
 *
 */
class ExampleChapter4Test extends FunSuite {

  test("Options Test") {
    val result = getUser(1).flatMap(a => getUser(2).flatMap(b => getUser(3).map(c=>a+b+c)))

    println(result)
  }

  def getUser(x: Int): Option[Int] = if (x < 10) Some(x) else None
}
