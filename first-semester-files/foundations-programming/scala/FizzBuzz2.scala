object FizzBuzz2{
  def main(args: Array[String]):Unit ={
    val list = (1 to 100).toList
    val listMapp = list.map(x => (x % 3, x % 5)) match {
      case (0,0) => "FizzBuzz"
      case (_,0) => "Fizz"
      case (0,_) => "Buzz"
      case _ => x
    }).foreach(println)
  }
  

}
