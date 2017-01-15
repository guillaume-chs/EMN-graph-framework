package guillaume_chs.graph.undirected

import guillaume_chs.graph.IGraph

/**
  * Interface IUndirectedGraph to manipulate specific non-oriented graphs.
  *
  * @author Guillaume Chanson
  * @version 1.0
  */
trait IUndirectedGraph extends IGraph {
  /**
    * Returns the number of edges in the graph.
    *
    * @return the number of edges
    */
  def getNbEdges: Int

  /**
    * Returns true if there is an edge between from and to.
    *
    * @param from starting node
    * @param to   ending node
    * @return true if an edge exists between the two nodes; false otherwise
    */
  def isEdge(from: Int, to: Int): Boolean

  /**
    * Removes edge (from, to) if exists.
    *
    * @param from starting node
    * @param to   ending node
    */
  def removeEdge(from: Int, to: Int): Unit

  /**
    * Adds edge (from, to) is not already present, requires x != y.
    *
    * @param from starting node
    * @param to   ending node
    */
  def addEdge(from: Int, to: Int): Unit

  /**
    * Returns a new Array[Int] representing neighbors of given node.
    *
    * @param node given node
    * @return a new array with neighbors of given node
    */
  def getNeighbors(node: Int): Array[Int]
}
