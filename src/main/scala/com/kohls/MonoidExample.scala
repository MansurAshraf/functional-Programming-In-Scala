package com.kohls

/**
 *
 * @author Muhammad Ashraf
 * @since 1/13/13
 *
 */
object MonoidExample {

  trait Monoid[A] {

    def zero: A

    def op(a1: A, a2: A): A
  }

  class AdditionMonoid {
    def identity = 0

    def op(a1: Int, a2: Int) = a1 + a2
  }

  val monoid = new AdditionMonoid
  val ints = List(1, 2, 3)
  ints.foldLeft(monoid.identity)(monoid.op)

  class JsonObfsucator extends Monoid[String] {
    val MASTER_CARD_REGEX = "\\b\\d{13,16}\\b"
    val SSN_REGEX = "\\b[0-9]{3}-[0-9]{2}-[0-9]{4}\\b"
    val BLOCK_TEXT = "*********"

    def zero = ""

    def op(a1: String, a2: String) = {
      val cleaned_text = a2.replaceAll(MASTER_CARD_REGEX, BLOCK_TEXT).replaceAll(SSN_REGEX, BLOCK_TEXT)
      a1 + cleaned_text + ","
    }

  }


}
