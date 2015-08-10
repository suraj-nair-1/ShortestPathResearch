The following instructions detail how to use the included code to simulate
Dijkstra's algorithm on a random graph, both implemented in Prolog and in Java.

-First, you must have the two included JAR files, stdlib.jar and algs4.jar 
included in your classpath for these files to work. These libraries are 
standard libraries containing precise data structure and algorithm implementations
by Princeton professors Robert Sedgewick and Kevin Wayne. We will use their 
implementation of the standard graph theory Dijkstra's algorithm to compare
to the implementation in Logic Programming.

-Next run the randomgraph executable from the commandline. This file takes two 
arguments, the number of desired nodes, and the name of the starting node.
It then creates a random graph of however many nodes have been specified, 
writes that graph into a text file that can be read by the standard Dijkstra's 
implementation as well as into a set of Prolog rules that can be read by the
Logic Programming implementation. It then calculates the shortest path from the 
specified starting node to all of the other nodes using the standard Java 
implementation and outputs the shortest path, as well as the runtime of the 
algorithm in milliseconds. 

For Example, to create a random graph of 5 nodes, and list all of the 
shortest paths from Node 2 to all of the other nodes using the standard
Dijkstra implementation, one would run the follwing from the command line 
once in the correct working directory:

*************************************************************************

$ java -cp stdlib.jar:algs4.jar:. randomgraph 5 2

Sample Output:

2 to 0 (34.00)  2->0 34.00   
2 to 1 (56.00)  2->3 40.00   3->4  1.00   4->1 15.00   
2 to 2 (0.00)  
2 to 3 (40.00)  2->3 40.00   
2 to 4 (41.00)  2->3 40.00   3->4  1.00   
Runtime: 16

*************************************************************************

-Now to test the implementation in Prolog, one would need to have SWI-Prolog
installed and first open the SWI-Prolog Console. Once in the correct working
directory, one would first need to source in the random graph which was 
already generated, by calling

*************************************************************************

?- [randgraph].

*************************************************************************

-Then, to source in the Shortest Path implementation in prolog, one would
call

*************************************************************************

?- [dijksra_test].

*************************************************************************

-Then, one can query the shortest path between any two nodes by calling
time(go("Start", "End")) For example, in the same random graph as the 
example for the standard implementatin above, to find the shortest path
between nodes 2 and 1, we would call:

*************************************************************************

?- time(go(n2,n1)).

Sample Output:

Shortest path is [n2,n3,n4,n1] with distance 0+40+1+15 = 56
% 9,309 inferences, 0.002 CPU in 0.013 seconds (15% CPU, 4833333 Lips)
true.

*************************************************************************

As we can see, the path matches the standard implementation. In general, I
have observed that for small size graphs, the Prolog implementation is better
because it does not require the extra time or space of creating graph, edge, 
and vertex objects. However,as we scale up in size, the standard graph theory 
implementation becomes considerably faster. 






