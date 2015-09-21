package org.vds.dicoverscala.core.ch05

import org.scalatest.{Matchers, WordSpec}

/**
 * Test.
 */
class LiteralSymbolBitWideTest extends WordSpec with Matchers {

  "Integer Literal" when {
    "Use Hex" should {
      "Hex-s values 0x5 and 0x255 have corresponding values" in {
        0x5 should be(5)
        0xff should be(255)
      }
    }
  }

  "Symbol" when {
    "Use symbol as type" should {
      "Should return Type symbol" in {
        'symbol shouldBe a[Symbol]
      }
    }
  }

  "Equal" when {
    "use eq function" should {
      "== check equal between two object" in {
        assert(List(1, 2, 3) == List(1, 2, 3))
        assert(1 == 1.0)
      }
    }
    "eq return true then it is the same reference" in {
      val aList1 = List(1, 2, 3)
      val aList2 = aList1

      assert(aList1.eq(aList2))
    }
    "ne return true then it is not the same reference" in {
      val aList1 = List(1, 2, 3)
      val aList2 = List(1, 2, 3)
      val aNull = null

      assert(aList1.ne(aList2))
    }
    "ne return true for null" in {
      var aNull = null;
      val aList = List(1, 2, 3)
      assert(aNull ne aList)
    }
  }
}
