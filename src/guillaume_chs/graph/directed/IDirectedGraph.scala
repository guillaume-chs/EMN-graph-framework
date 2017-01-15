package guillaume_chs.graph.directed

import guillaume_chs.graph.IGraph

/**
  * Interface IDirectedGraph to manipulate specific oriented graphs.
  *
  * @author Guillaume Chanson
  * @version 1.0
  */
trait IDirectedGraph extends IGraph {
  /**
    * Returns the number of arcs in the graph.
    *
    * @return the number of arcs
    */
  def getNbArcs: Int

  /**
    * Returns true if there is an arc between from and to.
    *
    * @param from starting node
    * @param to   ending node
    * @return true if an arc exists between the two nodes; false otherwise
    */
  def isArc(from: Int, to: Int): Boolean

  /**
    * Removes arc (from, to) if exists.
    *
    * @param from starting node
    * @param to   ending node
    */
  def removeArc(from: Int, to: Int): Unit

  /**
    * Adds arc (from, to) is not already present, requires x != y.
    *
    * @param from starting node
    * @param to   ending node
    */
  def addArc(from: Int, to: Int): Unit

  /**
    * Returns a new Array[Int] representing successors of given node.
    *
    * @param node given node
    * @return a new array with successors of given node
    */
  def getSuccesors(node: Int): Array[Int]

  /**
    * Returns a new Array[Int] representing predecessors of given node.
    *
    * @param node given node
    * @return a new array with predecessors of given node
    */
  def getPredecessors(node: Int): Array[Int]

  /**
    * Computes the inverse graph.
    *
    * @return the inverse graph
    */
  def computeInverse: IDirectedGraph
}
