object Fac{
  
  def main(args: Array[String]): Unit ={
    println()
  } 

  def fact(n: Int): Int = {
    if(n > 1) n * fact(n - 1) else 1
  }

  def fib(n: Int): Int = {
    if(n < 3) 1 else fib(n - 1) + fib(n - 2)
  }
  
  def lengthList(xs: List[Int]): Int = {
    if(xs.isEmpty) 0 else 1 + length(xs.tail)
  }

  def sumPM(xs: List[Int]): Int = xs match{
    case Nil => 0
    case x :: tail => x + sum(tail)
  }

  def sumTR(xsL List[Int]): Int = {
    @tailrec
    def iter(xs: List[Int], acc: Int) = {
      xs match {
        case Nil => acc
        case x => iter(xs.tail, acc + xs.head)
      }
    }
    iter(xs, 0)
  }
}
