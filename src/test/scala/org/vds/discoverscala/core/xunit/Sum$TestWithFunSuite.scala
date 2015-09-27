package org.vds.discoverscala.core.xunit

import org.scalatest.{Matchers, WordSpec, FlatSpec, FunSuite}


class Sum$TestWithFunSuite extends FunSuite {
  test("should Sum.add(1,3) be equal 3") {

    val a = 1 + 2

    assert(Sum.add(1, 2) == 3)
  }
}

class Sum$TestWithFlatSuite extends FlatSpec {

  "Sum.add(1,3)" should "be equal 3" in {
    assert(Sum.add(1, 2) == 3)
  }

  "Sum.add(0)" should "be equals 0" in {
    assertResult(0) {
      Sum.add(0, 0)
    }
  }
}

class Sum$TestWithWordSpec extends WordSpec {
  "Sum" when {
    "add(1,2)" should {
      "be equals 3" in {
        assert(Sum.add(1, 2) == 3)
      }
    }
  }
}
