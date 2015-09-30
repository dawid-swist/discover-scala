package org.vds.discoverscala.core.ch08

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by swistdaw on 2015-09-30.
 */
class FunctionAndClosures extends WordSpec with Matchers {

  "Partial function" when {
    "Define partial function for def sum(a: Int, b: Int, c: Int) = a + b + c" should {

      def sum(a: Int, b: Int, c: Int) = a + b + c
      "be instance of Int => Int" in {
        val partiallyFunction = sum(1, 1, _: Int)
        assert(partiallyFunction.isInstanceOf[Int => Int])
      }
      "return real value when we use them" in {
        val partiallyFunction = sum(1, 1, _: Int)
        assert(5 == partiallyFunction(3))
      }
    }
  }


  "Closure" when {
    "Define closure and free variable" should {
      "Remember value of variable of different closure" in {
        var more = 10
        val clo1 = (x: Int, y: Int) => x + y + more

        more = 20
        val clo2 = (x: Int, y: Int) => x + y + more

        more = 100

        clo1(1, 1) should be(100 + 1 + 1)
        clo2(1, 1) should be(100 + 1 + 1)

      }
    }
  }
}
