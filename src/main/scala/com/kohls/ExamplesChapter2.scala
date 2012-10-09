package com.kohls

/**
 * @author Muhammad Ashraf
 * @since 6/14/12
 */

object ExamplesChapter2 {

  type Int2Int = Int => Int

  class exercise2 {
    def absolute(f: Int2Int): Int2Int = i => scala.math.abs(i)
  }

}
