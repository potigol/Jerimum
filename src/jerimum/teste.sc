package jerimum
import scala.collection.SortedMap

object teste {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var x = SortedMap[Int, List[String]]()          //> x  : scala.collection.SortedMap[Int,List[String]] = Map()
  x += 2 -> List("a","b")
  x += 0 -> List("ewew")
  x.values.flatten                                //> res0: Iterable[String] = List(ewew, a, b)
}