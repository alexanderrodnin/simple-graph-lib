# Simple graph lib
---  
  
### Introduction
Simple graph lib is a lib for working with graph structures.

Library supports 2 types of graphs: 
- directed
- undirected

Graph has operations:
- addVertex - adds vertex to the graph
- addEdge - adds edge to the graph
- getPath - returns a list of edges between 2 vertices
  
  
Vertex is a user defined type.

### APIs
#### Vertex
Vertex is a user defined type.
#### Edge
```java
com.alexanderrodnin.simplegraphlib.model.Edge
```
Edge - data class. Represents connection between two vertices.
##### Methods:
```java
//source vertex
Vertex getSource() 

//destination vertex
Vertex getDestination()
```
#### Graph 
```java
com.alexanderrodnin.simplegraphlib.Graph
```
Graph represents a graph structure. Working with user defined type of vertex.
##### Methods:
```java
// Add vertex to the graph
void addVertex(Vertex vertex);

// Add edge to the graph
void addEdge(Edge<Vertex> edge);

// Find path between two vertices
List<Vertex> getPath(Vertex source, Vertex destination);

```
##### Implementations
Graph has two implementations:
```java
// Unfirected graph implementation
com.alexanderrodnin.simplegraphlib.UndirectedGraph

// Directed graph implementation
com.alexanderrodnin.simplegraphlib.UndirectedGraph
```

#### GraphModel 
```java
com.alexanderrodnin.simplegraphlib.model.GraphModel
```
Represents the model of graph structure.
##### Methods:
```java
// Add vertex
void addVertex(Vertex vertex);

// Add edge
void addEdge(Vertex source, Vertex destination);

// Returns all vertices
Set<Vertex> getAllVertices();

// Returns all edges
Set<Edge> getAllEdges();

// Returns connected vertices
Set<Vertex> getConnectedVertices(Vertex vertex);

// check if vertex contains
boolean containsVertex(Vertex vertex);

// check if edge between two vertices contains
boolean containsEdge(Vertex source, Vertex destination);
```
##### Implementations
Simple graph lib has one implementation of GraphModel - DefaultGraphModel:
```java
com.alexanderrodnin.simplegraphlib.model.DefaultGraphModel
```
DefaultGraphImplementation represent graph structure as 
```java
private final Map<Vertex, Set<Vertex>> graph = new HashMap<>();
```
Used for Directed and undirected graph.  
For undirected graph this structure is denormolized. It was made for asses efficiently to vertices and edges with O(1).  
Be carefull: methods of DefaultGraphModel:
```java
// Returns all edges
Set<Edge> getAllEdges();

// Returns connected vertices
Set<Vertex> getConnectedVertices(Vertex vertex);
```
return mutalbe sets. It also was made for efficient.

#### PathFindStrategy 
```java
com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy
```
PathFindStrategy represents the strategy of path finding algorithm between two Vertices.
##### Methods:
```java
// FindPath
    List<Vertex> findPath(GraphModel<Vertex> graphModel, Vertex source, Vertex destination);
```
##### Implementations
PathFindStrategy has one implementation:
```java
com.alexanderrodnin.simplegraphlib.finder.FirstFoundPathFindStrategy
```
It's a simple recursive in depth algorithm of finding first(path doesn’t have to be optima) between two vertices. 


### Exceptions
#### VertexAlreadyExistException 
```java
com.alexanderrodnin.simplegraphlib.exceptions.VertexAlreadyExistException
```
throws if graph already contains the vertex.

#### EdgeAlreadyExistException
```java
com.alexanderrodnin.simplegraphlib.exceptions.EdgeAlreadyExistException
```
throws if graph already contains the edge.

#### GraphHasNotContainVertex
```java
com.alexanderrodnin.simplegraphlib.exceptions.GraphHasNotContainVertex
```
throws if graph has not contain vertex.

### GraphBuilder
Graph builder represents simple interface for instantiation of graph.
```java
// Create directed graph
static <Vertex> GraphBuilder<Vertex> directed()

// Create undirected graph
static <Vertex> GraphBuilder<Vertex> undirected() 

// Set custom path find strategy
GraphBuilder<Vertex> setCustomPathFindStrategy(PathFindStrategy<Vertex> pathFindStrategy) 

// Set custom model
GraphBuilder<Vertex> setCustomGraphModel(GraphModel<Vertex> graphModel)

// Add vertex
GraphBuilder<Vertex> addVertex(Vertex vertex) 

// Add edge
GraphBuilder<Vertex> addEdge(Vertex source, Vertex destination)

// Add edge
GraphBuilder<Vertex> addEdge(Edge<Vertex> edge)
```

### Examples
#### Create default directed graph
```java
// with builder
Graph graph = GraphBuilder.<String>directed()
        .addVertex("A")
        .addVertex("B")
        .addEdge("A", "B")
        .build();

// with constructor
Graph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(new Edge<>("B", "A"));

```
#### Create default undirected graph
```java
// with builder
Graph graph = GraphBuilder.<String>directed()
        .addVertex("A")
        .addVertex("B")
        .addEdge("A", "B")
        .build();

// with constructor
Graph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(new Edge<>("B", "A"));

```

#### Create graph with custom path finder
```java
Graph graph = GraphBuilder.<String>undirected()
        .setCustomPathFindStrategy((graphModel, source, destination) -> new ArrayList<>( Arrays.asList("A", "B")))
        .addVertex("A")
        .addVertex("B")
        .addEdge("A", "B")
        .build();

```

### Project build
Repository contains gradlew wrapper and gradle build.
For build project next command should be executed:
```java
// for linux, mac
./gradlew build

// for windows
gradlew.bat build
```

