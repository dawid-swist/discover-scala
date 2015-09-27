package org.vds.discoverscala.core.ch06

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by swistdaw on 2015-09-23.
 */
class ChRationalTest extends WordSpec with Matchers {

  "For Rational class" when {
    "Create new object with param 3 and 6" should {
      "equal 1/2 " in {
        val rational1 = new Rational(3, 6)
        val rational2 = new Rational(1, 2)

        rational1 should equal(rational2)
        assert(rational1 == rational2)
      }
    }
    "For params (2/0)" should {
      "Throw exception" in {
        intercept[IllegalArgumentException] {
          new Rational(2, 0)
        }
      }
    }
  }

  "Rational method" when {
    "we use add " should {
      "return 1/1 for 1/2+1/2" in {
        new Rational(1 , 2) + new Rational(1 , 2) should be(new Rational(1))
      }
    }


  }

}
