package org.vds.dicoverscala.core.Ch04

import org.scalatest.{Matchers, WordSpec}

/**
 * It is example test with scala object
 */
class ObjectsTest extends WordSpec with Matchers {

  object Calculate {
    def add(x: Int, y: Int) = x + y

    def getAValue = new Calculate().a
  }

  class Calculate {
    private val a = 33
  }

  "Scala object" when {
    """define object class with definiction
      |  object Calculate {
      |    def add(x: Int, y: Int) = x + y;
      |    def getAValue = new Calculate().a
      |  } """.stripMargin should {

      "Add two value when we use Calculate.add(1,2)" in {
        Calculate.add(1, 2) should be(3)
      }

      "Object should has access to private member of class with the same name" in {
        Calculate.getAValue should be(33)
      }
    }
  }
}
