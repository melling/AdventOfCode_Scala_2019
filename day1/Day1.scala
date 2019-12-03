import scala.math.{abs, max}

object Day1 extends App {

  var massList = List(1969, 14, 14)

  def calcFuel(mass: Int) = mass / 3 - 2

  //@tailrec
  def calcFuel2(mass: Int): Int = {
    if (mass <= 0) {
      return 0
    }
    val requiredFuel = max(mass / 3 - 2, 0)
    //  print(s"$requiredFuel")
    return requiredFuel + calcFuel2(requiredFuel)
  }

  println("Day 1")

  def test_part1() = {
    //val t3 = calcFuel(100756)
    assert(calcFuel(14) == 2)
    assert(calcFuel(1969) == 654)
    assert(calcFuel(100756) == 33583)
  }

  def test_part2() = {
    assert(calcFuel2(14) == 2)
    assert(calcFuel2(1969) == 966)

    assert(calcFuel2(100756) == 50346)

  }
  test_part1()
  test_part2()
  val s = data()
  //print(s"$s")
  // val ys = s.split("\\s+")
  // print(s"$ys")

  //val strings = Seq("1", "2", "foo", "3", "bar")
  //val s0 = strings.flatMap(_.toIntOption) // 2.13 adds toIntOption
  // print(s"$s0")
  val xs: List[Int] = s.split("\\s+").flatMap(_.toIntOption).toList
  //print(s"$xs")
  massList = xs

  val result1 = massList.map(calcFuel).sum
  println(s"\nresult1=$result1")

  val result2 = massList.map(calcFuel2).sum
  println(s"result2=$result2")

  def data(): String = {

    val xs = """
85364
97431
135519
119130
137800
85946
146593
141318
103590
138858
92329
94292
132098
144266
72908
112896
87046
133058
141121
74681
83458
107417
121426
66005
106094
96458
113316
142676
79186
55480
147821
116419
70532
105344
116797
126387
139600
136382
121330
123485
134336
141201
131556
91346
117939
58373
129325
102237
60644
96712
126342
98939
66305
111403
143257
58721
55552
139078
74263
125989
90904
91058
92130
53176
81369
100856
110597
111141
129749
123822
75321
80963
102625
70161
107069
117982
86443
95627
147801
149508
101470
81879
133396
82276
144803
67049
127735
121064
122975
69435
139132
141284
70798
117921
108942
85662
75438
122699
116654
126797
"""
    xs
  }
}

