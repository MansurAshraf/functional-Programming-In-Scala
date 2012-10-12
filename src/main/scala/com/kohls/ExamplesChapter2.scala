package com.kohls

import javax.management.remote.rmi._RMIConnection_Stub

/**
 * @author Muhammad Ashraf
 * @since 6/14/12
 */

object ExamplesChapter2 {

  type Int2Int = Int => Int
  type Pred[A] = A => Boolean

  class Exercise2 {
    def absolute(f: Int2Int): Int2Int = x => scala.math.abs(f(x))
  }

  class Exercise4 {
    def divisibleBy[A](k: Int): Pred[Int] = x => x % k == 0
  }

  class Exercise5 {
    def even(i: Int) = new Exercise4().divisibleBy(2)(i)
  }

  class Exercise6 {
    def isDivisibleBy3And5: Pred[Int] = x => lift[Int]((a, b) => a && b, new Exercise4().divisibleBy(3), new Exercise4().divisibleBy(5))(x)

    def isDivisibleBy3Or5: Pred[Int] = x => lift[Int]((a, b) => a || b, new Exercise4().divisibleBy(3), new Exercise4().divisibleBy(5))(x)

    def lift[A](f: (Boolean, Boolean) => Boolean, g: Pred[A], h: Pred[A]): Pred[A] = x => f(g(x), h(x))
  }

  class Exercise9 {
    def componse[A, B, C](f: B => C)(g: A => B): A => C = a => f(g(a))
  }

}
