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

    def flatMap[B](f: (A) => Option[B]) = map(f).getOrElse(None)

    def getOrElse[B >: A](default: => B) = get

    def orElse[B >: A](ob: Option[B]) = this.map(Some(_)).getOrElse(ob)

    def filter(f: (A) => Boolean) = if (f(get)) this else None
  }

  case object None extends Option[Nothing] {
    def map[B](f: (Nothing) => B) = null

    def flatMap[B](f: (Nothing) => Option[B]) = None

    def getOrElse[B >: Nothing](default: => B) = default

    def orElse[B >: Nothing](ob: Option[B]) = ob

    def filter(f: (Nothing) => Boolean) = None
  }

}
