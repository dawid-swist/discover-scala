package org.vds.discoverscala.core.ch17

import org.scalatest.Matchers
import org.scalatest.Matchers
import org.scalatest.WordSpec
import org.scalatest.WordSpec
import org.scalatest.{Matchers, WordSpec}

import scala.collection.SortedSet
import scala.collection.immutable.TreeSet
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * Created by swistdaw on 2015-12-14.
  */
class Collections extends WordSpec with Matchers {
  "Arrays allow you to hold a sequence of elements and efficiently access an element at an arbitrary position" when {
    "we declare new array" should {
      "Build new Array" in {
        new Array[Int](5) should be(Array(0, 0, 0, 0, 0))
      }
    }
  }

  "A ListBuffer  is  a  mutable  list with fast append operation" when {
    "You use addend operation" should {
      "operator += append new element to end on List" in {
        (new ListBuffer[Int] += 1 += 2) should be(ListBuffer[Int](1, 2))
      }
      "Operator +=: add element to beging of List" in {
        3 +=: ListBuffer[Int](1, 2) should be(ListBuffer[Int](3, 1, 2))
      }
    }
  }
  "ArrayBuffer  array with add and  remove operation" when {
    "You use addend operation" should {
      "operator += append new element to end on List" in {
        (new ArrayBuffer[Int] += 1 += 2) should be(ArrayBuffer[Int](1, 2))
      }
    }
  }

  "Using Set and Map" when {
    "we use set" should {
      "create set using Set and add new number using +" in {
        Set(1, 2, 3) + 5 should be(Set(1, 2, 3, 5))
      }
      "create set using Set and remove element using -" in {
        Set(1, 2, 3) - 3 should be(Set(1, 2))
      }
      "create new Set and remove serval elements using --" in {
        Set(1, 2, 3, 4, 5) -- List(1, 2) should be(Set(3, 4, 5))
      }
      "Create new Set add add serval elements using ++" in {
        Set(1, 2) ++ List(3, 4, 6) should be(Set(1, 2, 3, 4, 6))
      }
      "return size of Set using Set.size" in {
        val setSize = Set(1, 2, 3, 4)
        setSize.size should be(4)
      }

      "We use Map" should {
        "Create new Map and add new element using + ('key'->value')" in {
          Map("i" -> 1, "ii" -> 2) + ("iii" -> 3) should be(Map("i" -> 1, "ii" -> 2, "iii" -> 3))
        }
        "Create new Map and add remove element using - ('key'->value')" in {
          Map("i" -> 1, "ii" -> 2, "iii" -> 3) - "iii" should be(Map("i" -> 1, "ii" -> 2))
        }
        "Create new Map and remove serval  elements using ++ List(('key'->value')...=" in {
          Map("i" -> 1, "ii" -> 2) -- List("iii", "i") should be(Map("ii" -> 2))
        }
        "Create new Map and add few elements using ++ List(('key'->value')...=" in {
          Map("i" -> 1) ++ List("iv" -> 4, "ii" -> 2) should be(Map("i" -> 1, "ii" -> 2, "iv" -> 4))
        }

        "Contains return true if key exists on Map" in {
          Map("i" -> 1, "ii" -> 2).contains("i") should be(true)
        }
      }

      "We need sortable Map and Set" should {
        "TreeSet should impalement SortedSet" in {
          TreeSet(2, 1, 3) shouldBe a[SortedSet[Int]]
          TreeSet(2, 1, 3) should contain inOrder(1, 2, 3)
        }
      }
    }
  }
}