package com.kohls

/**
 *
 * @author Muhammad Ashraf
 * @since 8/23/12
 *
 */
object ExampleChapter4 {

  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B]

    def flatMap[B](f: A => Option[B]): Option[B]

    def getOrElse[B >: A](default: => B): B

    def orElse[B >: A](ob: Option[B]): Option[B]

    def filter(f: A => Boolean): Option[A]
  }

  case class Some[+A](get: A) extends Option[A] {
    def map[B](f: (A) => B) = Some(f(get))

    def flatMap[B](f: (A) => Option[B]) = f(get)

    def getOrElse[B >: A](default: => B) = if (get == null) default else get

    def orElse[B >: A](ob: Option[B]) = null

    def filter(f: (A) => Boolean) = null
  }

  case object None extends Option[Nothing] {
    def map[B](f: (Nothing) => B) = null

    def flatMap[B](f: (Nothing) => Option[B]) = null

    def getOrElse[B >: Nothing](default: => B) = null

    def orElse[B >: Nothing](ob: Option[B]) = null

    def filter(f: (Nothing) => Boolean) = null
  }

}
