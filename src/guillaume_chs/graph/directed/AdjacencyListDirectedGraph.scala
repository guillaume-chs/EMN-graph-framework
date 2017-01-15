package guillaume_chs.graph.directed

import guillaume_chs.graph.GraphTools

/**
  * Created by guillaume-chs on 13/01/17.
  */
class AdjacencyListDirectedGraph(var adjacencyMatrix: Array[Array[Int]]) extends IDirectedGraph {
  var adjacencyList: Array[Array[Int]] = GraphTools.matrixToList(adjacencyMatrix)
  var nbArcs: Int = adjacencyMatrix.flatten.count(_ == 1) / 2
  var nbNodes: Int = adjacencyMatrix.length

  def this(directGraph: IDirectedGraph) = this(directGraph.toAdjacencyMatrix)

  /**
    * Returns the number of nodes in the graph (=> order of the graph).
    *
    * @return the order of the graph
    */
  override def getNbNodes: Int = nbNodes

  /**
    * Returns the number of arcs in the graph.
    *
    * @return the number of arcs
    */
  override def getNbArcs: Int = nbArcs

  /**
    * Returns true if there is an arc between from and to.
    *
    * @param from starting node
    * @param to   ending node
    * @return true if an arc exists between the two nodes; false otherwise
    */
  override def isArc(from: Int, to: Int): Boolean = adjacencyMatrix(from)(to) == 1

  /**
    * Removes arc (from, to) if exists.
    *
    * @param from starting node
    * @param to   ending node
    */
  override def removeArc(from: Int, to: Int): Unit = {
    if (isArc(from, to)) {
      adjacencyMatrix(from)(to) == 0
      adjacencyList(from) = adjacencyList(from).filterNot(_ == to)
    }
  }

  /**
    * Adds arc (from, to) is not already present, requires x != y.
    *
    * @param from starting node
    * @param to   ending node
    */
  override def addArc(from: Int, to: Int): Unit = {
    require(!isArc(from, to))

    adjacencyMatrix(from)(to) == 1
    adjacencyList(from) = adjacencyList(from) :+ to
  }

  /**
    * Returns a new Array[Int] representing successors of given node.
    *
    * @param node given node
    * @return a new array with successors of given node
    */
  override def getSuccesors(node: Int): Array[Int] = adjacencyList(node)

  /**
    * Returns a new Array[Int] representing predecessors of given node.
    *
    * @param node given node
    * @return a new array with predecessors of given node
    */
  override def getPredecessors(node: Int): Array[Int] = adjacencyMatrix.zipWithIndex.filter(_._1.contains(node)).map(_._2)

  /**
    * Computes the inverse graph.
    *
    * @return the inverse graph
    */
  override def computeInverse: IDirectedGraph = ???


  /**
    * Returns the adjacency matrix representation of the graph.
    *
    * @return the adjacency matrix representation of the graph
    */
  override def toAdjacencyMatrix: Array[Array[Int]] = adjacencyMatrix
}