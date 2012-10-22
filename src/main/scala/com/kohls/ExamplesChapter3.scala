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

    def foldRight[A, B](a: List[A], seed: B)(f: (A, B) => B): B = {
      a match {
        case Nil => seed
        case Con(x, xs) => f(x, foldRight(xs, seed)(f))
      }
    }

    def foldLeft[A, B](a: List[A], seed: B)(f: (A, B) => B): B = {
      a match {
        case Nil=>seed
        case Con(x,xs)=> foldLeft(xs,f(x,seed))(f)
      }
    }

    def apply[A](as: A*): List[A] = {
      if (as.isEmpty) Nil
      else Con(as.head, apply(as.tail: _*))
    }

  }


}
