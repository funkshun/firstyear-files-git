object FizzBuzz{
  def main(args: Array[String]):Unit ={
  val y = Range(1, 101).toList
  fizzer(y)
  } 

  def fizzer(xs: List[Int]): Unit = {
    if(xs.isEmpty) println("End") 
    else if(xs.head % 15 == 0) println("FizzBuzz" + fizzer(xs.tail)) 
    else if(xs.head % 5 == 0) println("Buzz" + fizzer(xs.tail)) 
    else if(xs.head % 3 == 0) println("Fizz" + fizzer(xs.tail))
    else println(xs.head + "" + fizzer(xs.tail))
  }
}
