package UMLDiagram.composition;

/* Library has a composition relationship with the Books class
 * Since books class can't exist outside of Library class
 */

public class Library {

	private static class Books {

	}

	Books[] book;

	public Library() {
		book = new Books[50];
	}

	void addBook(Books b) {
		book[0] = b;
	}
}


