package org.vds.discoverscala.core.ch02

import org.scalatest.{Matchers, WordSpec}

/**
 * Example for loop-s
 */
class LoopExampleTest extends WordSpec with Matchers {

  "Type of look" when {
    "We use while loop" should {

      "add increment value and return string with contains number 1,2,3,4,5" in {

        var results: String = ""
        var i = 1

        while (i < 6) {
          results += i
          i += 1
        }

        results should equal("12345")
      }
    }

    "When we use foreach loop on list element for concat to string" should {
      val expectResult = "12345"
      "return string " + expectResult in {

        val list = List(1, 2, 3, 4, 5)
        var res: String = ""

        list.foreach(res += _)
        res should equal(expectResult)
      }
    }
  }
}
