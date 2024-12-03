import java.util.*;

//Develop a Book class with attributes for title, author, and year of publication.
//Implement a toString() method to display book details clearly.
public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;

    //Constructor
    public Book(String title,String author,int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //Getter
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return year;
    }
    //toString method for display
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
    //Default Sorting by Title: Implement the Comparable interface in the Book class for alphabetical sorting by title.
    @Override
    public int compareTo(Book otherBook){
        return this.title.compareToIgnoreCase(otherBook.title);
    }

}

//Sorting Features:
//
//Author Sorting: Create a Comparator for sorting books by author names.

class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2){
        return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
    }
}
//Year Sorting: Develop a Comparator that sorts books by publication year, prioritizing newer books.

class YearComparator implements Comparator<Book>{
    @Override
    public int compare(Book b1, Book b2){
        return Integer.compare(b2.getYear(),b1.getYear());
    }
}

//Chained Sorting: Design a comparator that first sorts by author and then by title if the authors are the same.
class AuthorThenTitleComparator implements Comparator<Book>{
    @Override
    public int compare(Book b1,Book b2){
        int authorCompare = b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
        if(authorCompare !=0){
            return authorCompare;
        }else
            return b1.getTitle().compareToIgnoreCase(b2.getTitle());

    }
}