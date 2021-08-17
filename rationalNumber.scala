import scala.io.StdIn.readInt

object rationalNumber extends App{

  class Rational(x: Int, y: Int){
    require(y>0);
    private def gcd(a: Int, b: Int):Int = if(b==0) a  else gcd (b, a%b);
    def numer = x/gcd(x,y);
    def denom = y/gcd(x,y);

    def neg = new Rational(-this.numer,this.denom);
    def +(that: Rational) = new Rational(this.numer * that.denom + that.numer * this.denom, denom * that.denom);
    def -(that:Rational) = this + that.neg;
  }

  val x = new Rational(3,4);
  val y = new Rational(5,8);
  val z = new Rational(2,7);
  println((x-y-z).numer);
  println((x-y-z).denom);  //x=3/4, y=5/8, z=2/7.
}
