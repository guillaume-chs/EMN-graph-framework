package guillaume_chs.graph

import guillaume_chs.graph.undirected.AdjacencyListUndirectedGraph

/**
  * Created by guillaume-chs on 13/01/17.
  */
object Test {
  def main(args: Array[String]): Unit = {

    val data = GraphTools.generateGraphData(3, 4, symetric = true)
    println(data.deep.mkString("\n"))
    println()

    val graph = new AdjacencyListUndirectedGraph(data)
    println(graph.getNbEdges)
  }
}
