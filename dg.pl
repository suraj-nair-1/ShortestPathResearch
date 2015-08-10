list(X) :- dijkstra_av([d(n0,n4,18),d(n0,n5,4),d(n1,n2,50),d(n1,n9,19),d(n2,n4,8),d(n2,n5,23),d(n2,n8,17),d(n2,n9,49),d(n3,n4,41),d(n3,n5,42),d(n3,n6,39),d(n3,n7,3),d(n4,n5,20),d(n5,n6,16),d(n5,n8,29),d(n6,n8,38)], n1,X), 
 maplist(writeln,X).
