package org.vds.discoverscala.core.ch06

class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(i: Int): Rational = new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Rational = new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational = new Rational(numer * i, denom)

  def /(that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational = new Rational(numer, denom * i)

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def canEqual(other: Any): Boolean = other.isInstanceOf[Rational]

  override def equals(other: Any): Boolean = other match {
    case that: Rational =>
      (that canEqual this) &&
        numer == that.numer &&
        denom == that.denom
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(numer, denom)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
