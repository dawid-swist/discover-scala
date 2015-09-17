package org.vds.dicoverscala.core.ch03

import org.scalatest.{Matchers, WordSpec}

/**
 * Tests Example of usage List, Array, tube, set and map
 */
class ArrayMapSetAndListForTest extends WordSpec with Matchers {

  val exampleOfArray = Array(1, 2)
  "Example of Arrays usage" when {
    "Declare new Array with value" + exampleOfArray.toList should {

      "Be the same type in " in {
        exampleOfArray.foreach(_ shouldBe a[Integer])
      }

      "exampleOfArray(0) return 1" in {
        exampleOfArray(0) should equal(1)
      }

      "exampleOfArray(1) return 2" in {
        exampleOfArray(1) should equal(2)
      }

      "exampleOfArray.apply(1) return that same value as exampleOfArray(1)" in {
        exampleOfArray.apply(1) should equal(exampleOfArray(1));
      }

      "method exampleOfArray.update(0,3) should be has the same results as exampleOfArray(0)=3" in {

        val copyArray_1 = exampleOfArray.clone();
        val copyArray_2 = exampleOfArray.clone();

        copyArray_1(0) = 3;
        copyArray_1 should not equal (copyArray_2);
        copyArray_2.update(0, 3)

        copyArray_1 should equal(copyArray_1)
      }
    }
  }

  val exampleOfList = List("One", "Two", 3)
  "Example of List usage" when {
    "We define new list with value" + exampleOfList should {

      "contain One for exampleOfList(0)" in {
        exampleOfList(0) should be("One")
      }

      "has size 3" in {
        exampleOfList.size should be(3)
      }

      "return new object when we add new list to current List" in {

        val newExampleOfList = exampleOfList ::: List(4)
        assert(newExampleOfList.ne(exampleOfList))

        newExampleOfList.apply(3) should equal(4)
      }
    }
  }


}
