import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class BookTest {
    //testing to sort by title, author, and year
    public static void main(String[] args){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997));
        books.add(new Book("Harry Potter and the Deathly Hallows","J.K. Rowling",2007));
        books.add(new Book("Life After Life","Jill McCorkle",2013));
        books.add(new Book("Life After Life","Kate Atkinson",2013));
        books.add(new Book("Joyland","Emily Schultz",2006));
        books.add(new Book("Joyland","Stephen King",2013));


        //Default Sorting by Title
        System.out.println("Default sorting by title:");
        Collections.sort(books);
        books.forEach(System.out::println);

        //Sorting by Author
        System.out.println("Default Sorting by author: ");
        books.sort(new AuthorComparator());
        books.forEach(System.out::println);

        //Sorting by Year
        System.out.println("Default Sorting by author: ");
        books.sort(new YearComparator());
        books.forEach(System.out::println);

        //Sorting by Author, then title
        System.out.println("Default Sorting by author, then title: ");
        books.sort(new AuthorThenTitleComparator());
        books.forEach(System.out::println);


    }

    //Edge Case
    @Test
    void testEmptyBookList(){
        List<Book> books = new ArrayList<>();
        List<Book> sortedBooks = new ArrayList<>(books);

        Collections.sort(sortedBooks);
        assertTrue(sortedBooks.isEmpty());
    }


    @Test
    void testIdenticalAuthor(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter and the Philosopher's Stone","J.K. Rowling",1997));
        books.add(new Book("Harry Potter and the Deathly Hallows","J.K. Rowling",2007));
        books.add(new Book("Harry Potter and the Goblet of Fire","J.K. Rowling",2000));
        List<Book> sortedBooks = new ArrayList<>(books);

        //Test default author sorting
        sortedBooks.sort(new AuthorComparator());
        assertEquals("J.K. Rowling", sortedBooks.get(0).getAuthor());
    }
    @Test
    void testIdenticalTitle() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Life After Life", "Jill McCorkle", 2013));
        books.add(new Book("Life After Life", "Kate Atkinson", 2013));
        books.add(new Book("Joyland", "Emily Schultz", 2006));
        books.add(new Book("Joyland", "Stephen King", 2013));
        List<Book> sortedBooks = new ArrayList<>(books);

        //Test default author sorting
        Collections.sort(sortedBooks);
        assertEquals("Joyland", sortedBooks.get(0).getTitle());
        assertEquals("Life After Life", sortedBooks.get(2).getTitle());


    }
}
