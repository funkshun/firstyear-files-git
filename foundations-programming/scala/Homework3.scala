object Homework3{
  
  def main(args: Array[String]):Unit = {
    val list1 = List(1, 2, 3)
    println(myProduct(list1))
    println(myLast(list1))
    println(mySecondToLast(list1))
    println(myReplicate(5, 3))
    println(myReverse(list1))
    println(myElem(3, list1))
  } 

  def myProduct(xs: List[Int]): Int = {
    if(xs.isEmpty) 1 else xs.head * myProduct(xs.tail)
  }

  def myLast(xs: List[Int]): Int = {
    if(xs.length == 1) xs(0) else myLast(xs.tail)
  }

  def mySecondToLast(xs: List[Int]): Int = {
    if(xs.length == 2) xs.head else mySecondToLast(xs.tail)
  }

  def myReplicate(x: Int, n: Int): List[Int] = {
    if(n==1) List(x) else x :: myReplicate(x, n-1)
  }

  def myReverse(xs: List[Int]): List[Int] = {
    if(xs.length == 1) xs else myReverse(xs.tail):+ xs.head
  }

  def myElem(x: Int, xs: List[Int]): Boolean = {
    if(xs.isEmpty) false else if(xs.head == x ) true else myElem(x, xs.tail)
  }
}
