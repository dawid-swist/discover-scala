package org.vds.discoverscala.core.ch21

import org.scalatest.{FlatSpec, Matchers}

class ImplicitConversion extends FlatSpec with Matchers {


  it should "Convert automatically Double to Int using Implicit Conversion using def doubleToInt(x:Double) = x.toInt" in {
    implicit def doubleToInt(x: Double) = x.toInt

    val value: Int = 3.5
    value should be(3)
  }

  def presentYourName(name: String, age: String = "n/a")(implicit preference: Map[Symbol, String]) = {
    val sep = preference('separator)
    val ret = StringBuilder.newBuilder + (preference('nameLabel)) + (sep) +
      (name) + (", ") + (preference('ageLabel)) +
      (sep) + (age)
    ret.toString
  }

  "Implicit parameter" should "provide preferences as implicit parameter in function be inject" in {
    implicit val preference = Map('nameLabel -> "first name", 'ageLabel -> "age", 'separator -> ": ")

    presentYourName("Dawid") should be("first name: Dawid, age: n/a")
  }

  "Implicit parameter" should "preferences be overwrite by preference parameter" in {

    presentYourName("Dawid")(Map(
      'nameLabel -> "NAME",
      'ageLabel -> "AGE",
      'separator -> ": ")) should be("NAME: Dawid, AGE: n/a")
  }

}