package org.vds.dicoverscala.core.ch03

import org.scalatest.{Matchers, WordSpec}

/**
 * Tests Example of usage List, Array, tube, set and map
 */
class ArrayMapTubleSetAndListForTest extends WordSpec with Matchers {

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

        val copyArray1 = exampleOfArray.clone();
        val copyArray2 = exampleOfArray.clone();

        copyArray1(0) = 3;
        copyArray1 should not equal (copyArray2);
        copyArray2.update(0, 3)

        copyArray1 should equal(copyArray1)
      }
    }
  }

  val exampleOfList = List("One", "Two", 3)
  "Example of List usage" when {
    "We define new list with value" + exampleOfList should {

      "contain One for exampleOfList(0)" in {
        exampleOfList(0) should be("One")
        exampleOfList.head should be("One")
      }

      "has size 3" in {
        exampleOfList.size should be(3)
      }

      "return new object when we add new list to current List" in {

        val newExampleOfList = exampleOfList ::: List(4)
        assert(newExampleOfList.ne(exampleOfList))

        newExampleOfList.apply(3) should equal(4)
      }

      " create new list using method ::" in {
        val oneTwoThree = 1 :: 2 :: 3 :: Nil

        oneTwoThree.size should be(3)
        oneTwoThree should contain(1)
        oneTwoThree should contain(2)
        oneTwoThree should contain(3)
      }
    }
  }

  "List api usage" when {

    "Create empty list" should {

      "list has zero size" in {
        val emptyList1 = Nil
        val emptyList2 = List()

        emptyList1.size should be(0)
        emptyList2.size should be(0)
      }
    }
    "we use method count" should {
      "from list 1 2 3 4 count number of element _ >2" in {
        List(1, 2, 3, 4).count(_ > 2) should be(2)
      }
    }

    "we use filter method on List list(1 2 3 4)" should {

      "filter every element _ > 3 and keep only 4" in {
        List(1, 2, 3, 4).filter(_ > 3) should equal(List(4))
      }
      " filter every element _ > 3 and not contain 1 2 3" in {
        List(1, 2, 3, 4).filter(_ > 3) should not contain (1)
        List(1, 2, 3, 4).filter(_ > 3) should not contain (2)
        List(1, 2, 3, 4).filter(_ > 3) should not contain (3)
      }
    }

    "we use method exists" should {
      "return true for condition _ > 3" in {
        List(1, 2, 3, 4).exists(_ > 3) should be(true)
      }
      "return false for condition _ > 10" in {
        List(1, 2, 3, 4).exists(_ > 10) should be(false)
      }
    }

    "we use function drop" should {
      "return List(2,3,4) for drop(1)" in {
        List(1, 2, 3, 4).drop(1) should equal(List(2, 3, 4))
      }
      "return List(3,4) for drop(2)" in {
        List(1, 2, 3, 4).drop(2) should equal(List(3, 4))
      }
    }

    "we use function dropRight" should {
      "return List(2,3,4) for dropRight(1)" in {
        List(1, 2, 3, 4).dropRight(1) should equal(List(1, 2, 3))
      }
      "return List(1,2) for dropRight(2)" in {
        List(1, 2, 3, 4).dropRight(2) should equal(List(1, 2))
      }
    }

    "we use forAll" should {
      "return true for forAll(_ < 5)" in {
        List(1, 2, 3, 4).forall(_ < 5) should be(true)
      }
      "return false for forAll(_ < 5)" in {
        List(1, 2, 3, 4).forall(_ > 5) should be(false)
      }
    }

    "we use simple method like first head tail" should {
      "for method head return 1" in {
        List(1, 2, 3, 4).head should be(1)
      }
      "for method last return 4" in {
        List(1, 2, 3, 4).last should be(4)
      }
      "for method init return 1 2 3" in {
        List(1, 2, 3, 4).init should be(List(1, 2, 3))
      }
      "for method tail return 2 3 4" in {
        List(1, 2, 3, 4).tail should be(List(2, 3, 4))
      }
    }

    "we use map" should {
      "return List(2,3,4,5) for map(_ + 1 )" in {
        List(1, 2, 3, 4).map(_ + 1) should be(List(2, 3, 4, 5))
      }
    }

    "we use reverse and sort" should {
      "return list 4,3,2,1 for function reverse" in {
        List(1, 2, 3, 4).reverse should be(List(4, 3, 2, 1))
      }
    }
  }


  val exampleOfTuble = (99, "Luftballons", 1l)
  "Scala tuble" when {
    "We define tuble this value " + exampleOfTuble should {
      "return 99 for method _1" in {
        exampleOfTuble._1 should be(99)
      }
      "return type Int for _1" in {
        assert(exampleOfTuble._1.isInstanceOf[Int])
      }
      "return 'Luftballons' for method _2" in {
        exampleOfTuble._2 should be("Luftballons")
      }
      "return type String for _2" in {
        assert(exampleOfTuble._2.isInstanceOf[String])
      }
    }
  }


  val exampleOfSet = Set(1, 2, 3)
  "Example of Set " when {
    "We declare new Set with value " + exampleOfSet should {
      "apply() check that element is on set" in {
        Set(1, 2, 3).apply(1) should be(true)
        Set(1, 2, 3)(7) should be(false)
      }
      "operator =+ 7 add new element to set" in {
        exampleOfSet + 7 should contain(7)
        exampleOfSet + 7 should contain(2)
        exampleOfSet + 7 should contain(3)
        exampleOfSet + 7 should contain(1)
      }
    }
  }

  val exampleOfMap = Map(1 -> "one", 2 -> "two", 3 -> 3)
  "Example of Map class" when {
    "We declare new map with value " + exampleOfMap should {
      "operator + should add new element" in {
        val newElement = exampleOfMap + (4 -> "4")
        newElement(4) should equal("4")
      }
      "apply return value by key" in {
        exampleOfMap.apply(1) should be("one")
        exampleOfMap.apply(2) should be("two")
        exampleOfMap(3) should be(3)
      }
    }
  }
}
