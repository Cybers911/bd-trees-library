import org.apache.commons.lang3.NotImplementedException;
import treestructure.BookNode;

/**
 * Application to test traversing Binary Trees and Binary Search Trees.
 *
 * Represents a Library with a collection of books.
 */
public class LibraryService {

    /**
     * The root node of our tree of Books.
     * Assume this tree is sorted by ISBN.
     * The tree and its nodes should not be modified by our application.
    */
    private final BookNode books;

    /**
     * Constructs our library with a default tree of books.
     * Assume this tree is sorted by ISBN.
     *
     * @param books The root node of a tree of Books
     */
    public LibraryService(final BookNode books) {
        this.books = books;
    }

    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given ISBN.
     *
     * @param isbn A given ISBN to search our library for
     * @return True if a book with the given ISBN is in our library and
     *         false otherwise
     */
    public boolean isBookInLibraryByIsbn(String isbn) {
        // PARTICIPANTS: IMPLEMENT YOUR BINARY SEARCH HERE

        BookNode current = books;
        while (current != null) {
            int comparison = isbn.compareTo(current.getBook().getIsbn());
            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        throw new NotImplementedException("isBookInLibraryByIsbn is not yet implemented!");
    }


    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given Title and Author.
     *
     * @param title A given title to search our library for, alongside an author's name
     * @param author The name of a given author to search our library for, alongside a title
     * @return True if a book with the given title and author is in our library, and
     *         false otherwise
     */
    public boolean isBookInLibraryByTitleAndAuthor(String title, String author) {
        // PARTICIPANTS: IMPLEMENT YOUR DEPTH FIRST SEARCH HERE
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            return false;
        }
        return depthFirstSearch(books, title, author);
    }
     private boolean depthFirstSearch(BookNode node, String title, String author) {
        if (node == null) {
            return false;
        }
         // Check if the current node's book matches the title and author
         if (node.getBook().getTitle().equals(title) && node.getBook().getAuthor().equals(author)) {
             return true;
         }
         // Recursively search left and right subtrees
         return depthFirstSearch(node.getLeft(), title, author) ||
                 depthFirstSearch(node.getRight(), title, author);

    }
}
