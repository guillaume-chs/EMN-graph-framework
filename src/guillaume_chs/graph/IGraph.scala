package guillaume_chs.graph

/**
  * Interface IGraph to manipulate graphs.
  *
  * @author Guillaume Chanson
  * @version 1.0
  */
trait IGraph {
  /**
    * Returns the number of nodes in the graph (=> order of the graph).
    *
    * @return the order of the graph
    */
  def getNbNodes: Int

  /**
    * Returns the adjacency matrix representation of the graph.
    *
    * @return the adjacency matrix representation of the graph
    */
  def toAdjacencyMatrix: Array[Array[Int]]

  /**
    * Returns the adjacency list representation of the graph.
    *
    * @return the adjacency list representation of the graph
    */
  def toAdjacencyList: Array[Array[Int]]
}