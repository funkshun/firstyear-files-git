object FizzBuzz{
  def main(args: Array[String]):Unit ={
    val listNums = Range(1, 101).toList
    fizzBuzzH(listNums)
  }


  def fizzBuzzH(x: List[Int]):Unit = {
    if (x.tail == Nil)
      println()
    else if (x.head % 15 == 0)
      println("fizzbuzz")
    else if (x.head % 5 == 0)
      println("buzz")
    else if (x.head % 3 == 0)
      println("fizz")
    else
      println(x.head)
      fizzBuzzH(x.tail)
 
    //fizzBuzzH(x.tail)
      
     
  }
}

