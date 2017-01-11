object Homework1{
				
  def sum(x: Int, y: Int): Int ={x + y}
  def sumSquared(x: Int, y: Int): Int = {(x * x) + (y * y)}
  def sumCube(x: Int, y: Int) = {(x * x * x) + (y * y * y)}
  def retMax(x: Int, y: Int): Int = {
    if (x == y) x
    else if (x > 0) x
    else y
  }
  def double100(x: Int): Int = {
    if(x < 100) 2 * x else x
  }
  def doubleEven(x: Int): Int = {
    if(x % 2 == 0) 2 * x else x
  }
  def tripleOdd(x: Int): Int = {
    if(x % 2 == 1) 3 * x else x
  }
}
