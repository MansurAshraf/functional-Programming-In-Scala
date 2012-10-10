package com.kohls


import org.scalatest.FlatSpec

/**
 * @author Muhammad Ashraf
 * @since 10/10/12
 */
class ExamplesChapter2Test extends FlatSpec {

  trait fixture {
    val ex2 = new ExamplesChapter2.Exercise2
  }

  "Absoulate function" should "return only positive values" in new fixture {
    val result: Int = ex2.absolute(x => x * -1)(4)
    assert(result === 4)
  }

}
