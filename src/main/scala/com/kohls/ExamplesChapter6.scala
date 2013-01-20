package com.kohls

import collection.mutable


/**
 *
 * @author Muhammad Ashraf
 * @since 1/10/13
 *
 */
object ExamplesChapter6 {
  implicit def toB(x: Any) = x.asInstanceOf[Boolean]

  class MutableShoppingCartService(val session: mutable.HashMap[String, Any]) {

    def login(username: String, password: String): Boolean = {
      if (username == "MVP" && password == "MVP") {
        session += ("isLoggedIn" -> true)
      } else {
        session += ("isLoggedIn" -> false)
      }
      session("isLoggedIn")
    }

    def addItemToCart(quantity: Int): Boolean = {
      if (session("isLoggedIn")) {
        session +=(("cart" -> quantity), ("isCartEmpty" -> false))
      } else {
        session += ("isCartEmpty" -> true)
      }
      !session("isCartEmpty")
    }

    def checkout: Boolean = {
      if (session("isLoggedIn") && !session("isCartEmpty")) {
        session += ("checkoutStatus" -> "successfull")
        true
      } else {
        session +=(("checkoutStatus" -> "failure"), ("reason" -> "User not Logged in or Cart is empty"))
        false
      }
    }

  }

  class ShoppingCartService {
    def login(username: String, password: String): State[Map[String, Any], Boolean] = State {
      session =>
        if (username == "MVP" && password == "MVP") {
          val updatedSession = session + ("isLoggedIn" -> true)
          (updatedSession, true)
        } else {
          val updatedSession = session + ("isLoggedIn" -> false)
          (updatedSession, false)
        }
    }

    def addItemToCart(quantity: Int): State[Map[String, Any], Boolean] = State {
      session =>
        if (session("isLoggedIn")) {
          val updatedSession = session +(("cart" -> quantity), ("isCartEmpty" -> false))
          (updatedSession, true)
        } else {
          val updatedSession = session + ("isCartEmpty" -> true)
          (updatedSession, true)
        }
    }


    def checkout: State[Map[String, Any], Boolean] = State {
      session =>
        if (session("isLoggedIn") && !session("isCartEmpty")) {
          val updatedSession = session + ("checkoutStatus" -> "successfull")
          (updatedSession, true)
        } else {
          val updatedSession = session +(("checkoutStatus" -> "failure"), ("reason" -> "User not Logged in or Cart is empty"))
          (updatedSession, false)
        }
    }
  }


  trait State[S, +R] {
    def run(seed: S): (S, R)

    def map[R1](f: R => R1): State[S, R1] = State {
      s => val (s1, r1) = run(s)
      (s1, f(r1))
    }

    def flatMap[R1](f: R => State[S, R1]): State[S, R1] = State {
      s => val (s1, r1) = run(s)
      f(r1).run(s1)
    }
  }

  object State {
    def apply[S, R](f: S => (S, R)): State[S, R] = new State[S, R] {
      def run(seed: S) = f(seed)
    }
  }


}
