package org.vds.dicoverscala.core.ch02

import org.scalatest.{Matchers, WordSpec}

import scala.runtime.BoxedUnit

/**
 * This test class show what is different between val and var.
 */
class ValVarFunctionTest extends WordSpec with Matchers {

  "val declaration" when {
    "we assigned some value" should {
      "we get the same value" in {
        val val_1 = 1
        assertResult(1) {
          val_1
        }
      }
    }
  }

  "var declaration" when {
    "Change var value" should {
      "we return latest value" in {
        var var_1 = 1
        var_1 = 2

        var_1 should equal(2)
      }
    }
  }

  "Function" when {
    "we define function fun(n)" should {
      "function fun return value n" in {
        def fun(n: Any): Any = {
          n
        }

        fun("some Value") should equal("some Value")
      }
    }

    "Function max with definition def max2(x: Int, y: Int) = if (x > y) x else y" should {
      def max2(x: Int, y: Int) = if (x > y) x else y

      "return max=10 when we run max(1,10)" in {
        max2(1, 10) should equal(10)
      }
    }

    """Function with definition def greet() = println("Hello, world!")""" should {
      def greet() = println("Hello, world!")

      "return type until()" in {

        val result = greet()

        assert(result.isInstanceOf[Unit])
      }
    }

  }

}
