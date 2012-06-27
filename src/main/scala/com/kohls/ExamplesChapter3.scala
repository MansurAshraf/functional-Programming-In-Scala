package com.kohls

/**
 * @author Muhammad Ashraf
 * @since 6/20/12
 */

object ExamplesChapter3 {

  sealed trait MList[+A]

  case object MNil extends MList[Nothing]

  case class MCons[+A](head: A, tail: MList[A]) extends MList[A]

  object MList {
    def sum(ints: MList[Int]): Int = ints match {
      case MNil => 0
      case MCons(x, xs) => x + sum(xs)
    }

    def product(ints: MList[Int]): Int = ints match {
      case MNil => 1
      case MCons(0, _) => 0
      case MCons(x, xs) => x * product(xs)
    }

    def tail[A](ints: MList[A]): MList[A] = ints match {
      case MNil => MNil
      case MCons(x, MNil) => MNil
      case MCons(x, xs) => xs
    }

    def drop[A](l: MList[A])(n: Int): MList[A] = l match {
      case MNil => MNil
      case MCons(x, xs) if n > 0 => drop(xs)(n - 1)
      case MCons(x, xs) if n <= 0 => MCons(x, xs)
    }

    def dropWhile[A](l: MList[A])(pred: A => Boolean) = l match {
      case MNil => MNil
      case MCons(x, xs) if pred(x) => xs
      case MCons(x, xs) if !pred(x) => MCons(x, xs)
    }
  }

}
