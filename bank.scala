import scala.io.StdIn.readInt

object bank extends App{

  class Account(s:String, n:Int, b:Double){
    val nic:String = s;
    val accountNumber:Int = n;
    var balance:Double = b;

    override def toString = "[" + nic + ":" + accountNumber + ":" + balance + "]";

    def withdraw(x:Double) = {
      this.balance = this.balance-x;
    }
    def deposit(x:Double) = {
      this.balance = this.balance+x;
    }
    def transfer(a:Account, x:Double) = {     //transfer from one account to another
      this.balance = this.balance+x;
      a.balance = a.balance-x;
    }
  }

  var a = new Account("abc", 1, 20.0);
  var b = new Account("def", 2, 30.0);

  b.transfer(a, 30);
  println(a); println(b);

  var Bank:List[Account] = List(a,b);
  val overdraft = (x:List[Account]) => x.filter((a:Account) => a.balance < 0);   //List of accounts with negative balances
  println(overdraft(Bank));

  val totalBalance = (x:List[Account]) => x.foldLeft(0.0)((a,b) => a+b.balance);   //the sum of all account balances
  println(totalBalance(Bank));

  val interest = (x:List[Account]) => x.map(acc => if(acc.balance > 0) acc.balance* 0.05 else acc.balance* 0.1);    //Interest for all accounts considering their account balances
  println(interest(Bank));
}
