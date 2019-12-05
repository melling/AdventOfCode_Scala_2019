/*
https://stackoverflow.com/questions/32431729/how-to-efficient-copy-an-array-to-another-in-scala

https://stackoverflow.com/questions/11448685/scala-how-can-i-count-the-number-of-occurrences-in-a-list

 */

object Day04 {

  def int2List(num: Int): List[Int] = {
    //val lst = List(1, 2)
    val xs: List[Int] = num.toString.toList.map(_.toString).map(_.toInt)
    // println(s"$xs")

    xs
  }

  def testNum(num: Int): Boolean = {
    val digits = int2List(num)
    if (digits.length != 6) {
      return false
    }
    val lst = digits map (x => digits.count(_ == x))
    // println(s"lst = $lst")
    // val numSeq = lst.filter(_ >= 2).length // Part 1
//    val numSeq = lst.filter(_ == 2).length // Part 2
    val numSeq = lst.count(_ == 2) // Part 2

    if (numSeq < 2) {
      return false
    }
    // println(s"numSeq = $numSeq")

    // digits.sliding(2)
    for (List(left, right) <- digits.sliding(2) if left > right ) {
      //  println(s"false $left < $right")
      return false
    }

    true
  }

  def test(): Unit = {
    val num = 111111 // true
    val isValid = testNum(num)
    println(s"$num / $isValid")

    val num2 = 223450 // false
    val isValid2 = testNum(num2)
    println(s"$num2 / $isValid2")

    val num3 = 123789 // false
    val isValid3 = testNum(num3)
    println(s"$num3 / $isValid3")

  }

  def part1(): Unit = {
    // test()
    var ctr = 0
    for (num <- 130254 to 678275) {
      val isValid = testNum(num)
      if (isValid) {
        ctr = ctr + 1
      }
    }
    println(s"result=$ctr")
  }

}

//Day04.test()
Day04.part1()

