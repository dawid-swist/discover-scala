package org.vds.discoverscala.core.ch17

import org.scalatest.{Matchers, WordSpec}

class Abstractions extends WordSpec with Matchers {

  "Type members on abstract traits" when {
    "we define following abstract trait and implementation " should {
      trait IElement {
        type T
        val XValue: T
        val YValue: T
      }

      class ImplementationOfIElement extends IElement {
        type T = Float
        val XValue = 1f
        val YValue = 2f;
      }

      "IElement should allow has defalue value of type of T" in {
        new ImplementationOfIElement().XValue should be(1f)
        new ImplementationOfIElement().YValue should be(2f)
      }
    }
  }

  "We can use lazy" when {
    "lazy must postpone execute some code" should {
      "variable should used only when is execute" in {

        class LazyClass {
          var someCalculateValueWasExecuted = false
          lazy val someCalculateValue: String = {
            this.someCalculateValueWasExecuted = true
            "MyValue"
          }

          def execute(): Unit = {
            this.someCalculateValue
          }
        }

        val lazyClass = new LazyClass

        lazyClass.someCalculateValueWasExecuted should be(false)
        lazyClass.execute()
        lazyClass.someCalculateValueWasExecuted should be(true)
      }
    }
  }
}
