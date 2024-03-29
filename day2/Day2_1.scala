//var opcodes = Array(1, 0, 0, 3, 99)
/*
 Once you have a working computer, the first step is to restore the gravity assist program (your puzzle input) to the "1202 program alarm" state it had just before the last computer caught fire. To do this, before running the program, replace position 1 with the value 12 and replace position 2 with the value 2. What value is left at position 0 after the program halts?
 */
val s =
  "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,1,19,5,23,1,23,9,27,2,27,6,31,1,31,6,35,2,35,9,39,1,6,39,43,2,10,43,47,1,47,9,51,1,51,6,55,1,55,6,59,2,59,10,63,1,6,63,67,2,6,67,71,1,71,5,75,2,13,75,79,1,10,79,83,1,5,83,87,2,87,10,91,1,5,91,95,2,95,6,99,1,99,6,103,2,103,6,107,2,107,9,111,1,111,5,115,1,115,6,119,2,6,119,123,1,5,123,127,1,127,13,131,1,2,131,135,1,135,10,0,99,2,14,0,0"
//var opcodes = Array(1,9,10,3,2,3,11,0,99,30,40,50)
var opcodes = Array(1, 0, 0, 0, 99)

val xs: Array[Int] = s.split(",").flatMap(_.toIntOption).toArray
opcodes = xs

def processOpcodes(programCounter: Int): Unit = {

  val opcode = opcodes(programCounter)

  opcode match {
    case 1 | 2 =>
      // add
      // println("add")

      val memoryPtr1 = opcodes(programCounter + 1)

      val memoryPtr2 = opcodes(programCounter + 2)

      val resultPtr = opcodes(programCounter + 3)
      val value1 = opcodes(memoryPtr1)
      val value2 = opcodes(memoryPtr2)
      var result: Int = 0

      if (opcode == 1) {
        result = value1 + value2
      } else {
        result = value1 * value2
      }
      opcodes(resultPtr) = result

      processOpcodes(programCounter + 4)

    case 99 => //halt
      println("halt")
      return
    case _ =>
      print("invalid cmd")
  }

}
//replace position 1 with the value 12 and replace position 2 with the value 2.
opcodes(1) = 12
opcodes(2) = 2
//
processOpcodes(0)
val answer = opcodes(0)
print(s"$answer")
