package com.kohls

/**
 * @author Muhammad Ashraf
 * @since 6/14/12
 */

object ExamplesChapter2 {
  type Pred[A] = A => Boolean

  def minBy(x: Int, y: Int, f: (Int, Int) => Boolean) = if (f(x, y)) x else y

  def max(x: Int, y: Int) = minBy(x, y, _ > _)

  def isEven(n: Int): Boolean = isDivisibleBy(2)(n)

  def not[A](f: Pred[A]): Pred[A] = x => !f(x)

  def isOdd(n: Int) = not[Int](isEven)(n)

  def isDivisibleBy(k: Int): Pred[Int] = i => i % k == 0

  def isDivisibleBy3And5(n: Int) = isDivisibleBy(3)(n) && isDivisibleBy(5)(n)

  def isDivisibleBy3Or5(n: Int) = isDivisibleBy(3)(n) || isDivisibleBy(5)(n)

  def applyIf[A](a: A, f: A => A, p: A => Boolean): A = bind[A, Boolean, A](a, p, (p1, p2) => if (p1) f(a) else a)

  def bind[A, B, C](a: A, p: A => B, f: (B, A) => C): C = f(p(a), a)

}
