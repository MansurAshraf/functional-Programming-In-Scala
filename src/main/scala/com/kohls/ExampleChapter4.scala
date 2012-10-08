package com.kohls

/**
 *
 * @author Muhammad Ashraf
 * @since 8/23/12
 *
 */
object ExampleChapter4 {

  sealed trait Option[+A]

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

}
