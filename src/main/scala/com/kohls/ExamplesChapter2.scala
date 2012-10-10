package com.kohls

/**
 * @author Muhammad Ashraf
 * @since 6/14/12
 */

object ExamplesChapter2 {

  type Int2Int = Int => Int

  class Exercise2 {
    def absolute(f: Int2Int): Int2Int = x => scala.math.abs(x)
  }

}
