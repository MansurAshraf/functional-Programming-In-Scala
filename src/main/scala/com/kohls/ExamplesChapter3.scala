package com.kohls

/**
 * @author Muhammad Ashraf
 * @since 6/20/12
 */

object ExamplesChapter3 {

  sealed trait List[+A] {
    def isEmpty: Boolean

    def head: A

    def tail: List[A]
  }

  case class Con[+A](head: A, tail: List[A]) extends List[A] {
    def isEmpty = false
  }

  case object Nil extends List[Nothing] {
    def isEmpty = true

    def head = throw new IndexOutOfBoundsException

    def tail = throw new IndexOutOfBoundsException
  }

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Con(head, tail) => head + sum(tail)
    }

    def product(ints: List[Double]): Double = ints match {
      case Nil => 1.0
      case Con(0.0, tail) => 0.0
      case Con(head, tail) => head * product(tail)
    }

    def tail[A](input: List[A]): List[A] = drop(1, input)

    def drop[A](n: Int, input: List[A]): List[A] = {
      if (input.isEmpty) Nil
      else if (n == 0) input
      else drop(n - 1, input.tail)
    }

    def dropWhile[A](input: List[A])(f: A => Boolean): List[A] = {
      if (input.isEmpty) Nil
      else if (!f(input.head)) input
      else dropWhile(input.tail)(f)
    }

    @annotation.tailrec
    def foldLeft[A, B](input: List[A], seed: B)(f: (A, B) => B): B = input match {
      case Nil => seed
      case Con(x, xs) => foldLeft(xs, f(x, seed))(f)
    }

    def map[A, B](list: List[A])(f: A => B): List[B] = {
      list match {
        case Nil => Nil
        case Con(x, xs) => Con(f(x), map(xs)(f))
      }
    }

   /* def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = {
      l match {
        case Nil => Nil
        case Con(x, xs) => Con(map(f(x))(k=>k), flatMap(xs)(f))

      }
    }*/

    def apply[A](as: A*): List[A] = {
      if (as.isEmpty) Nil
      else Con(as.head, apply(as.tail: _*))
    }

  }


}
