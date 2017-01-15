package guillaume_chs.graph

import scala.util.Random

/**
  * Static helper object to expose universal methods.
  *
  * @author Guillaume Chanson
  * @version 1.0
  */
object GraphTools {

  /**
    * Returns the adjacency matrix representing a randomly generated graph, using 3 parameters :
    * <ul>
    * <li>the number of nodes</li>
    * <li>the number of arcs/edges</li>
    * <li>whether the graph is directed or undirected</li>
    * </ul>.
    *
    * @param n        number of nodes
    * @param m        number of arcs/edges
    * @param symetric whether the graph is symetric (directed) or not (undirected)
    * @return the adjacency matrix representation of the generated graph
    */
  def generateGraphData(n: Int, m: Int, symetric: Boolean): Array[Array[Int]] = {
    require(n > 0)
    require(m >= 0)
    if (symetric) require(m % 2 == 0)

    var adjMatrix: Array[Array[Int]] = Array.fill(n, n)(0)
    val random = new Random()

    var i = 0
    for (i <- 0.to(m, if (symetric) 2 else 1)) {
      var x, y = 0
      do {
        x = random.nextInt(n)
        y = random.nextInt(n)
      } while (x == y && adjMatrix(x)(y) == 1)

      if (symetric) {
        adjMatrix(x)(y) = 1
        adjMatrix(y)(x) = 1
      } else {
        adjMatrix(x)(y) = 1
      }
    }

    adjMatrix
  }

  /**
    * Computes an adjacency list from given matrix.
    *
    * @param matrix matrix to compute
    * @return given matrix as adjancency list
    */
  def matrixToList(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    matrix.zipWithIndex.collect {
      case (line, i) =>
        line.zipWithIndex.collect {
          case (el, j) if el == 1 => j
        }
    }
  }
}
