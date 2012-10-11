package com.kohls


import org.scalatest.FlatSpec

/**
 * @author Muhammad Ashraf
 * @since 10/10/12
 */
class ExamplesChapter2Test extends FlatSpec {

  trait fixture {
    val ex2 = new ExamplesChapter2.Exercise2
    val ex4 = new ExamplesChapter2.Exercise4
    val ex5 = new ExamplesChapter2.Exercise5
    val ex6 = new ExamplesChapter2.Exercise6
  }

  "Absoulate function" should "return only positive values" in new fixture {
    val result: Int = ex2.absolute(x => x * -1)(4)
    assert(result === 4)
  }

  "Divisible By" should "return true when a number is divisible by k" in new fixture {
    assert(ex4.divisibleBy(2)(4) === true)
  }

  "Even" should "return true for even numbers" in new fixture {
    assert(ex5.even(200) === true)
  }

  "IsDivisible3And5" should "return true for 15" in new fixture {
    assert(ex6.isDivisibleBy3And5(15))
  }

  "IsDivisible3Or5" should "return true for 5" in new fixture {
    assert(ex6.isDivisibleBy3Or5(5)===true)
  }


}
