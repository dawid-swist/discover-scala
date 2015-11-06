package org.vds.discoverscala.core.ch15

import org.scalatest.{Matchers, WordSpec}

abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

class CaseClassesTest extends WordSpec with Matchers {

  "Chapter 15: Case class and Pattern matching" when {
    "define case class: Var(name: String) extends Expr, instance of class Var('10')" should {
      "has method toString with format [Var(10)]" in {
        val instanceOfVar = Var("10")
        instanceOfVar.toString() should be("Var(10)")
      }

      "be able to clone object for val op = BinOp(\"+\", Number(1), v)" in {
        val v = Var("x")
        val op1 = BinOp("+", Number(1), v)
        val op2 = op1.copy()

        op1 should be(op2)
        assert(op1.ne(op2))
      }
    }
    "We define pattern" should {
      "match wildcard pattern '_' be, if other don't be matched" in {

        def selector(expr: Any) = expr match {
          case BinOp(op, left, rigth) => "binary operator"
          case _ => "other operator"
        }

        val expression1 = selector(BinOp("+", Var("1"), Var("2")))
        val expression2 = selector(Number(3))

        expression1 should be("binary operator")
        expression2 should be("other operator")
      }

      "match corresponding value by constant pattern" in {

        def describe(x: Any) = x match {
          case 5 => "five"
          case true => "truth"
          case "hello" => "hi!"
          case Nil => "the empty list"
          case _ => "something else"
        }

        describe(5) should be("five")
        describe(true) should be("truth")
        describe("hello") should be("hi!")
        describe("non") should be("something else")
      }

      "match variable if is used" in {
        def matchByVariable(expr: Any) = {
          expr match {
            case 0 => "zero"
            case somethingElse => "not zero: " + somethingElse
          }
        }

        val somethingElse = 10;
        matchByVariable(0) should be("zero")
        matchByVariable(somethingElse) should be("not zero: " + somethingElse)
      }

      "match corresponding value using constructor pattern. e.x: case BinOp(\"+\", e, Number(0)) " in {

        def matchByConstructorPattern(expr: Expr) = expr match {
          case BinOp("+", e, Number(0)) => "a deep match"
          case _ => "N/A"
        }

        matchByConstructorPattern(Var("10")) should be("N/A")
        matchByConstructorPattern(BinOp("+", Var("e1"), Number(10))) should be("N/A")
        matchByConstructorPattern(BinOp("+", Var("e1"), Number(0))) should be("a deep match")
      }

      "match List by sequential pattern e.x: expr match {\ncase List(0, _, _) => \"found it\")}" in {

        def seqPattern(expr: Any) = expr match {
          case List(0, _, _) => "found it List(0,x,y)"
          case List(0, _*) => "found list List(1,.....)"
          case _ => "N/A"
        }

        seqPattern(List(0, 2, 3)) should be("found it List(0,x,y)")
        seqPattern(List(0, 2, 3, 4)) should be("found list List(1,.....)")
      }


      "match tubles e.x: case (a, b, c) => println(\"matched \"+ a + b + c)" in {
        def matchTuple(expr: Any) =
          expr match {
            case (a, b, c) => "matched " + a + b + c
            case _ =>
          }

        matchTuple((4, 3, 2)) should be("matched " + 4 + 3 + 2)
      }

      "match by type pattern e.x: case s: String => s.length\ncase m: Map[_, _] => m.size" in {
        def generalSize(x: Any) = x match {
          case s: String => s.length
          case m: Map[_, _] => m.size
          case _ => -1
        }

        generalSize("2020") should be(4)
        generalSize(Map("key" -> "value")) should be(1)
      }

      "use variable for bind some expression e.x: case UnOp(\"abs\", e @ UnOp(\"abs\", _)) => e" in {
        def patternWithViariable(expr: Expr) = expr match {
          case UnOp("abs", e@UnOp("abs", _)) => e
          case _ =>
        }
        val v = UnOp("abs", Number(10))

        patternWithViariable(UnOp("abs", v)) should be(v)
      }

      "match expression with a pattern guard e.x: case BinOp(\"+\", x, y) if x == y =>\nBinOp(\"*\", x, Number(2))" in {
        def simplifyAdd(e: Expr) = e match {
          case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
          case _ => e
        }

        simplifyAdd(BinOp("+", Number(5), Number(5))) should be(BinOp("*", Number(5), Number(2)))
      }

      "use options instead Null" in {
        def show(x: Option[String]) = x match {
          case Some(s) => s
          case None => "?"
        }

        val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

        show(capitals get "Japan") should be("Tokyo")
        show(capitals get "Poland") should be("?")
      }
    }

  }

}