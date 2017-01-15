package guillaume_chs.graph.undirected

import guillaume_chs.graph.GraphTools

/**
  * Created by guillaume-chs on 13/01/17.
  */
class AdjacencyListUndirectedGraph(var adjacencyMatrix: Array[Array[Int]]) extends IUndirectedGraph {
  var adjacencyList: Array[Array[Int]] = GraphTools.matrixToList(adjacencyMatrix)
  var nbEdges: Int = adjacencyMatrix.flatten.count(_ == 1) / 2
  var nbNodes: Int = adjacencyMatrix.length

  def this(undirectGraph: IUndirectedGraph) = this(undirectGraph.toAdjacencyMatrix)

  /**
    * Returns the number of edges in the graph.
    *
    * @return the number of edges
    */
  override def getNbEdges: Int = nbEdges

  /**
    * Returns the number of nodes in the graph (=> order of the graph).
    *
    * @return the order of the graph
    */
  override def getNbNodes: Int = nbNodes

  /**
    * Returns true if there is an edge between from and to.
    *
    * @param from starting node
    * @param to   ending node
    * @return true if an edge exists between the two nodes; false otherwise
    */
  override def isEdge(from: Int, to: Int): Boolean = adjacencyMatrix(from)(to) == 1

  /**
    * Removes edge (from, to) if exists.
    *
    * @param from starting node
    * @param to   ending node
    */
  override def removeEdge(from: Int, to: Int): Unit = {
    if (isEdge(from, to)) {
      adjacencyMatrix(from)(to) = 0
      adjacencyMatrix(to)(from) = 0

      adjacencyList(from) = adjacencyList(from).filterNot(_ == to)
      adjacencyList(to) = adjacencyList(to).filterNot(_ == from)
    }
  }

  /**
    * Adds edge (from, to) is not already present, requires x != y.
    *
    * @param from starting node
    * @param to   ending node
    */
  override def addEdge(from: Int, to: Int): Unit = {
    require(from != to)

    adjacencyMatrix(from)(to) = 1
    adjacencyMatrix(to)(from) = 1

    adjacencyList(from) :+ to
    adjacencyList(to) :+ from
  }

  /**
    * Returns a new Array[Int] representing neighbors of given node.
    *
    * @param node given node
    * @return a new array with neighbors of given node
    */
  override def getNeighbors(node: Int): Array[Int] = adjacencyList(node)

  /**
    * Returns the adjacency matrix representation of the graph.
    *
    * @return the adjacency matrix representation of the graph
    */
  override def toAdjacencyMatrix: Array[Array[Int]] = adjacencyMatrix

  /**
    * Returns the adjacency list representation of the graph.
    *
    * @return the adjacency list representation of the graph
    */
  override def toAdjacencyList: Array[Array[Int]] = adjacencyList
}