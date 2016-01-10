package org.vds.discoverscala.core.ch16

import org.scalatest.Matchers
import org.scalatest.WordSpec
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by swistdaw on 2015-12-14.
  */
class ListTest extends WordSpec with Matchers {

  "Example for List" when {
    "We trying to define new list" should {
      "use '::' and Nil operators for create new list. example of usage 1 :: 2 :: 3 :: 4 :: Nil" in {
        val newList = 1 :: 2 :: 3 :: 4 :: Nil
        newList should contain inOrder(1, 2, 3, 4)
      }

      "use List constructor for creating List example: List(1,2,3,4)" in {
        val newList = List(1, 2, 3, 4)
        newList should contain inOrder(1, 2, 3, 4)
      }
    }
  }

  "we use List operation head" should {
    "head return first element from list List(1,2,3,4)" in {
      val FIRST_ELEMENT = 1
      val list = List(FIRST_ELEMENT, 2, 3, 4)

      list.head should be(FIRST_ELEMENT)
    }

    "Throw 'NoSuchElementException' exception if we invoke head on empty list" in {
      val emptyList = List()
      intercept[NoSuchElementException] {
        emptyList.head
      }
    }
    "isEmpty should return true" in {
      List().isEmpty should be(true)
    }
  }

  "we use tail operation on list List(1,2,3,4)" should {
    "return 2,3,4 for tail" in {
      List(1, 2, 3, 4).tail should contain inOrder(2, 3, 4)
    }

    "isEmpty should return false" in {
      List(1, 2, 3, 4).isEmpty should be(false)
    }
  }

  "Concatenating two lists" should {
    "use operator ::: for concats 2 lists" in {
      val list1 = List(1, 2, 3, 4)
      val list2 = List(5, 6, 7)

      list1 ::: list2 should contain inOrder(1, 2, 3, 4, 5, 6, 7)
    }
  }

  "Use first and last and reverse methods in List" should {
    "List(1,2,3,4).first return 1,2,3" in {
      List(1, 2, 3, 4).init should contain inOrder(1, 2, 3)
    }

    "List(1,2,3,4).last return 4" in {
      List(1, 2, 3, 4).last should be(4)
    }

    "List(1,3,4).reverse return 4,3,1" in {
      List(1, 3, 4).reverse should contain inOrder(4, 3, 1)
    }
  }

  "Use take, drop and splitAt in List" should {
    "List(1,2,3,4).take 2 return 1,2" in {
      List(1, 2, 3, 4) take 2 should contain inOrder(1, 2)
    }

    "return empty List if we use take 0" in {
      List(1, 2, 3, 4).take(0).length should be(0)
    }

    "List(1,2,3,4) drop 2 return 3,4" in {
      List(1, 2, 3, 4).drop(2) should contain inOrder(3, 4)
    }

    "splitAt is enequals(xs take n, xs drop n)" in {
      List(1, 2, 3, 4).splitAt(2) should be((List(1, 2), (List(3, 4))))
    }
  }

  "Use apply and indices in List" should {
    "apply return element on current posision" in {
      val list = List(1, 2, 3, 4)
      list(2) should be(3)
    }

    "List(5,6,7) apply 2 be eq List(5,6,7)(2)" in {
      List(5, 6, 7) apply 2 should be(List(5, 6, 7)(2))
    }

    //TODO: figure out how to test check Range value
    //    "indices return index of collection" in {
    //      List("a", "b").indices should be(Range(0,1))
    //    }
  }

  "Flatten, zip and unzip in List" should {

    "Create flat List from List of Lists by using Flatten" in {
      List(List(1), List(2, 3, 4)).flatten should be(List(1, 2, 3, 4))
    }

    "The zip operation takes two lists and forms a list of pairs" in {
      List("a", "b", "c").zip(List(1, 2, 3)) should be(List(("a", 1), ("b", 2), ("c", 3)))
    }

    "Any list of tuples can be changed back to a tuple of lists by using the unzip method" in {
      val zippedList = List("a", "b", "c").zip(List(1, 2, 3))
      zippedList.unzip should be(List("a", "b", "c"), List(1, 2, 3))
    }
  }

  "use mkString for change toString format" should {
    "create different representation by using the mkString method" in {
      List(1, 2, 3).mkString("[", ";", "]").toString should be("[1;2;3]")
    }
  }

  "Converting lists: iterator, toArray , copyToArray" should {
    "convert List to array by the method toArray" in {
      List(1, 2, 3).toArray should be(Array(1, 2, 3))
    }

    "The operation: xs copyToArray (arr, start) copies all elements of the list xs to the array arr, beginning with position start" in {
      val array2 = new Array[Int](10)
      List(1, 2, 3).copyToArray(array2, 3)

      array2 should be(Array(0, 0, 0, 1, 2, 3, 0, 0, 0, 0))

    }
  }

  "Mapping over lists: map, flatMap and foreach" should {
    "The operation xs map f apply function f on every element of list and return new list" in {
      List("1", "aaa", "ccc").map(_.length) should be(List(1, 3, 3))
    }

    "The flatmap applies function to each list element and returns the concatenation of all function results" in {

      val listOfWords = List("The", "word", "of", "poland")

      listOfWords.map(_.toList) should be(List(List('T', 'h', 'e'), List('w', 'o', 'r', 'd'), List('o', 'f'), List('p', 'o', 'l', 'a', 'n', 'd')))
      listOfWords.flatMap(_.toList) should be(List('T', 'h', 'e', 'w', 'o', 'r', 'd', 'o', 'f', 'p', 'o', 'l', 'a', 'n', 'd'))
    }
  }

  "Filtering lists: filter , partition , find , takeWhile , dropWhile , and span" should {
    "The operation xs filter p takes as operands a list xs and a predicate function p of type T => Boolean and " +
      "return list of all elements x in xs for which p(x) is true ." in {

      List(1, 2, 3, 4, 5, 6, 7, 8).filter(_ % 2 == 0) should be(List(2, 4, 6, 8))
    }

    "The partition method returns a pair of lists.  One list contains  all  elements  for  which  the  predicate  is  true," +
      "while  the  other  list contains all elements for which the predicate is false." in {

      List(1, 2, 3, 4, 5, 6, 7, 8).partition(_ % 2 == 0) should be((List(2, 4, 6, 8), List(1, 3, 5, 7)))
    }

    "The operation xs takeWhile p takes the longest prefix of list xs such that every element in the prefix satisfies p" in {
      List(1, 2, 3, 0, -1, 10, 11).takeWhile(_ > 0) should be(List(1, 2, 3))
    }

    "he operation xs dropWhile p removes  the  longest  prefix  from  list xs such  that  every element in the prefix satisfies p" in {
      List(1, 2, 3, 0, -1, 10, 11).dropWhile(_ > 0) should be(List(-0, -1, 10, 11))
    }

    "The span method combines takeWhile and dropWhile in one operation. " +
      "It returns a pair of two lists: xs span p equals (xs takeWhile p, xs dropWhile p)" in {
      List(1, 2, 3, 0, -1, 10, 11).span(_ > 0) should be(List(1, 2, 3), List(0, -1, 10, 11))
    }
  }

  "Predicates over lists: forall and exists" should {
    "The operation xs FOREALL p takes as arguments a list xs and a predicate p . Its result is true if all elements in the list satisfy p" in {
      List(1, 2, 3, 4, 5).forall(_ > 0) should be(true)
      List(1, 2, 3, 4, 5).forall(_ > 1) should be(false)
    }

    "The operation xs exists p returns true if there is an element in xs that satisfies the predi- cate p" in {
      List(1, 2, 3, 4, 5).exists(_ > 4) should be(true)
      List(1, 2, 3, 4, 5).exists(_ < 1) should be(false)
    }
  }

  "Folding lists: /: and :\\" should {
    "Folding left: (z /: List(a, b, c)) (op) equals op(op(op(z, a), b), c)" in {
      ("z" /: List("a", "b", "c")) (_.toUpperCase() + _.toUpperCase()) should be("ZABC")
      List("a", "b", "c").foldLeft("z")(_ + _) should be("zabc") //Alternative version
    }

    "Folding rigth: (List(a, b, c) :\\ z) (op) equals op(a, op(b, op(c, z)))" in {
      (List("a", "b", "c") :\ "z") (_ + _) should be("abcz")
      List("a", "b", "c").foldRight("z")(_ + _) should be("abcz") //Alternative version
    }
  }
  "Sorting lists: sortWith" should {
    "The operation sortWith perfom soring using function f for sorting" in {
      List(3, 1, 10, -1).sortWith(_ < _) should be(List(-1, 1, 3, 10))
    }
  }

  "Fill, tabulate and concat in list:" should {
    "The fill method creates a list consisting of zero or more copies of the same element." in {
      List.fill(5)("-") should be(List("-", "-", "-", "-", "-"))
    }

    "The tabulate method creates a list whose elements are computed according to a supplied function." in {
      List.tabulate(10)(_ * 2) should be(List(0, 2, 4, 6, 8, 10, 12, 14, 16, 18))
    }

    "The concat method concatenates a number of element lists." in {
      List.concat(List("a", "b"), List("c")) should be(List("a", "b", "b"))
    }
  }
}
