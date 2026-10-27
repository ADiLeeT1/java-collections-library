// ===================== ШПАРГАЛКА: ГДЕ ЧТО ИСКАТЬ =====================
// Set (HashSet) - только уникальные элементы.
// Поля genres и uniqueBooks   - стр. 15-16
// add() - addGenre            - стр. 18
// remove() - removeGenre      - стр. 27
// contains() - hasGenre       - стр. 36
// Set<Book> + equals/hashCode - addUniqueBook, стр. 45
// =====================================================================

import java.util.HashSet;
import java.util.Set;

// Работа с Set: уникальные жанры (String) и уникальные книги (Book)
public class BookSetManager {
    private Set<String> genres = new HashSet<>();
    private Set<Book> uniqueBooks = new HashSet<>();

    public void addGenre(String genre) {
        boolean added = genres.add(genre);
        if (added) {
            System.out.println("add: " + genre);
        } else {
            System.out.println("add: " + genre + " -> already in the set, duplicate ignored");
        }
    }

    public void removeGenre(String genre) {
        boolean removed = genres.remove(genre);
        if (removed) {
            System.out.println("remove: " + genre);
        } else {
            System.out.println("remove: " + genre + " -> not found");
        }
    }

    public boolean hasGenre(String genre) {
        return genres.contains(genre);
    }

    public void printGenres() {
        System.out.println("Genres: " + genres + ", size = " + genres.size());
    }

    // Здесь HashSet использует наши equals() и hashCode() из класса Book
    public void addUniqueBook(Book book) {
        boolean added = uniqueBooks.add(book);
        if (added) {
            System.out.println("add: " + book);
        } else {
            System.out.println("add: book with id=" + book.getId() + " -> duplicate, not added");
        }
    }

    public int getUniqueBooksCount() {
        return uniqueBooks.size();
    }
}
