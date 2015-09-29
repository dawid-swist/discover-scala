package org.vds.discoverscala.core.ch07

import org.scalatest.{Matchers, WordSpec}

/**
 * Example for ch7. Control Structures
 */
class ControlStructures extends WordSpec with Matchers {

  "For structures for (i <- i to n){}" when {
    "We use range" should {
      "Interact from 1 to 4" in {
        var res = 1;

        for (i <- 1 to 4) {
          res = i;
        }

        assert(res == 4)
      }

      "able to filering numbers" in {
        var res = 0;

        for (
          i <- 1 to 4
          if i % 2 == 0
        ) res = res + i;

        assert(res == (2 + 4))
      }

      "Return collections using loop expession" in {
        val res = for (
          i <- 1 to 4
          if i % 2 == 0
        ) yield i;

        res should contain allOf(2, 4);
      }
    }

    "We use match expression" when {
      "Define simple match" should {
        "select corresponding cese block" in {
          val firstArg = "chips"

          val res =
            firstArg match {
              case "salt" => "pepper"
              case "chips" => "salsa"
              case "eggs" => "bacon"
              case _ => "huh?"
            }
          assert(res == "salsa")
        }

      }
    }

  }


}
