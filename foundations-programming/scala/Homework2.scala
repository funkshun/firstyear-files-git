object Homework2{
 
  
  def listCompare(xs: List[Any], ys: List[Any]): List[Any] = {
    if(xs.length >= ys.length) xs else ys
  }
  
  val countDownList = List.range(21, 1, 3)
  
  val listFrom100 = List.range(100, 0, 7)
  def headStealer(xs: List[Int], ys: List[Int], zs: List[Int]): List[Int] = {
    val retList = List(xs.head, ys.head, zs.head)
    retList
  }
  def tailStealer(xs: List[Int], ys: List[Int], zs: List[Int]): List[List[Int]] = {
    val retList = List(xs.tail, ys.tail, zs.tail)
    retList
  }
  def reverser(xs: List[Any], x: Int): List[Int] ={
    x :: xs.reverse
  } 
  def maxFinder(xs: List[Int], ys: List[Int]): List[Int] = {
    if(xs.max > ys.max || xs.max == ys.max) xs else ys
  }



}
