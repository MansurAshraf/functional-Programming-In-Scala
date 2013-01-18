package com.kohls

import org.scalatest.FunSuite
import com.kohls.MonoidExample.JsonObfsucator

/**
 *
 * @author Muhammad Ashraf
 * @since 1/13/13
 *
 */
class MonoidExampleTest extends FunSuite {

  test("Json Obsucator") {

    val json = """{
                 	"first": "John",
                 	"last": "Doe",
                 	"credit_card": 5105105105105100,
                 	"ssn": "123-45-6789",
                 	"salary": 70000,
                 	"registered": true
                 }"""

    val monoid = new JsonObfsucator

    val result: String = json.split(',').foldLeft(monoid.zero)(monoid.op)
    println(result)

  }


}
