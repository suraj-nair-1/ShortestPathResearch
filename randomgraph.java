// Random Graph Generator
import java.lang.Math;
import java.io.*;
import java.lang.management.*;

public class randomgraph {
	public static void main(String[] args) {
		System.setProperty("java.library.path", "Users/surajnair/Documents/Shortest_Path_Implementations");
		String dg = "list(X) :- dijkstra_av([";
		String graph = "";
		String graph2head = "" + java.lang.Integer.parseInt(args[0]) + "\n";
		String graph2 = "";
		int count = 0;
		for(int i = 0; i < java.lang.Integer.parseInt(args[0]); i++) {
			for(int j = i+1; j < java.lang.Integer.parseInt(args[0]) ; j++) {
				int c = (int)(2 * Math.random());
				int weight = 1 + (int)(50 * Math.random());
				if(c == 0) {
					graph += "d(" + "n"+ i + "," + "n"+ j + "," + weight + ").\n";
					dg += "d(" + "n"+ i + "," + "n"+ j + "," + weight + "),";
					graph2 += i + " " + j + " " + weight + "\n";
					graph2 += j + " " + i + " " + weight + "\n";
					count += 2;
				}
			}
		}
		dg = dg.substring(0, dg.length() - 1);
		dg += "], n" +args[1] + ",X), \n maplist(writeln,X).";
		try{
			PrintWriter writer = new PrintWriter("randgraph.pl", "UTF-8");
			PrintWriter w = new PrintWriter("randgraph.txt", "UTF-8");
			PrintWriter wrtr = new PrintWriter("dg.pl", "UTF-8");
			writer.println(graph);
			wrtr.println(dg);
			w.println(graph2head + count + "\n" + graph2);
			writer.close();
			wrtr.close();
			w.close();
		}
		catch(Exception e){
			System.out.println("Could not write to files");
		}

		In in = new In("randgraph.txt");
		long startTime = System.currentTimeMillis();
		long startUserTimeNano   = getUserTime( );
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = java.lang.Integer.parseInt(args[1]);

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
        long endTime   = System.currentTimeMillis();
        long taskUserTimeNano    = getUserTime( ) - startUserTimeNano;
      	long totalTime = endTime - startTime;
      	System.out.println("Wall time: " + totalTime);
      	System.out.println("CPU time: " + (taskUserTimeNano/1000000));

      	/*Query q1 = 
	    new Query( 
	        "consult", 
	        new Term[] {new Atom("dg.pl")} 
	    );*/


	}
 
	/** Get user time in nanoseconds. */
	public static long getUserTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    return bean.isCurrentThreadCpuTimeSupported( ) ?
	        bean.getCurrentThreadUserTime( ) : 0L;
	}
}










