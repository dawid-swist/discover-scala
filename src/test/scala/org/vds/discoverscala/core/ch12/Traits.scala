package org.vds.discoverscala.core.ch12

import org.scalatest._

/**
 * Created by swistdaw on 2015-10-26.
 */


trait TrainA {
  def A = 1
}

trait TraitB {
  def B = 2
}

class ClassWitTraitAB extends TrainA with TraitB {}

class Traits extends FlatSpec with Matchers {

  "ClassWithTraitAB implements TrainA and TrainB" should "has TrainA" in {
    val t: ClassWitTraitAB = new ClassWitTraitAB()
    t shouldBe a[TrainA]
  }

  "ClassWithTraitAB implements TrainA and TrainB" should "has TrainB" in {
    val t: ClassWitTraitAB = new ClassWitTraitAB()
    t shouldBe a[TraitB]
  }
}
