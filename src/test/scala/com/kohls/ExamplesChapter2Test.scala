package com.kohls

import org.scalatest.FlatSpec

/**
 * @author Muhammad Ashraf
 * @since 10/9/12
 */
class ExamplesChapter2Test extends FlatSpec {

  trait exercise2 {
    val ex2 = new ExamplesChapter2.exercise2
  }

  "Absolute" should "return absoulte value" in new exercise2 {

    val f: ExamplesChapter2.Int2Int = x => x * -1
    val result: Int = ex2.absolute(f)(2)
    assert(result === 2)
  }

}
