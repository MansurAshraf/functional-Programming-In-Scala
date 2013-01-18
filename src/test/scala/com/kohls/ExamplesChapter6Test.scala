package com.kohls

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.kohls.ExamplesChapter6.ShoppingCartService

/**
 *
 * @author Muhammad Ashraf
 * @since 1/10/13
 *
 */
class ExamplesChapter6Test extends FunSuite with ShouldMatchers {
  {
    val service = new ShoppingCartService
    /*    val result = service.login("MVP", "MVP")
          .flatMap(isUserLoggedIn => service.addItemToCart(4)
          .flatMap(isCartEmpty => service.checkout
          .map(isCheckoutSuccessful => List(isUserLoggedIn, isCartEmpty, isCheckoutSuccessful))))
          .run(Map())

        print(result)*/

    val cartService = for {
      isUserLoggedIn <- service.login("MVP", "MVP")
      isCartEmpty <- service.addItemToCart(4)
      isCheckoutSuccessful <- service.checkout
    } yield isCheckoutSuccessful

    val (session, result) = cartService.run(Map())
    println("Service Result: " + result)
    println("session: " + session)
  }
}
