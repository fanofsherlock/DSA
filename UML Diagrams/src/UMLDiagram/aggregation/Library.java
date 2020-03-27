package UMLDiagram.aggregation;

/*
 * Library and Books class has an aggregator relationship 
 * since Books class exists outside of Library
 */

public class Library {
	Books[] book;

	public Library() {
		book = new Books[50];
	}

	void addBook(Books b) {
		book[0] = b;
	}
}


