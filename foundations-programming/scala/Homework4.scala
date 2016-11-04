object Homework4{
  def main(args: Array[String]):Unit ={
    val list1 = List(1,2,3)
    println(doubleAll(list1))
    val list2 = List("She's All That", 
      "10 Things I Hate About You",
      "The Dark Knight Rises",
      "Notting Hill",
      "Jumper",
      "Terminator",
      "TerminatorWar Games")
      
    val areRomcoms = checkList(list2, isRomcom)
    println(areRomcoms)
    val movieDescriptions = checkList(list2, describeMovie)
    println(movieDescriptions)
    val loves = checkList(list2, loveActually)
    println(loves)
  } 

  
  def doubleAll(xs: List[Int]): List[Int] = {
    def iter(ys: List[Int], acc: List[Int]): List[Int] = {
      if(ys == Nil) acc else iter(ys.tail, acc:+ys.head:+ys.head)
    }
    iter(xs, List())
  }

//  def isPalindrome(xs: List[Int]): Boolean = {
//    def iter(ys: List[Int], acc1: Boolean, acc2: List[Int]): Boolean = {
//      if(ys == Nil) 
//    }
//  }

  def isRomcom(name: String): Boolean = {
    if(name == "She's All That" || name == "10 Things I Hate About You" || name == "Notting Hill") true else false
  }

  def describeMovie(name: String): String = {
    if(isRomcom(name)) name + "-so cute!" else name + "-action packed!"
  }

  def loveActually(name: String): String ={
    "Love Actually"
  }

  def checkList(names: List[String], f: String => Any): List[Any] = {
    def iter(name: List[String], f: String => Any,acc: List[Any]): List[Any] = {
    if(name == Nil) acc else iter(name.tail, f, acc :+ f(name.head))
    }
    iter(names, f, List())
  }
}
