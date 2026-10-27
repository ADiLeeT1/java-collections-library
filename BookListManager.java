// ===================== ШПАРГАЛКА: ГДЕ ЧТО ИСКАТЬ =====================
// List (ArrayList) - основной список книг, LinkedList - очередь читателей.
// Поля books и readerQueue        - стр. 30-31
// add (добавление)                - addBook,      стр. 35
// get(index) (получение)          - getBook,      стр. 40
// set(index) (изменение)          - updateBook,   стр. 47
// remove(index) (удаление)        - removeBook,   стр. 55
// size() (размер)                 - getSize,      стр. 63
// Проверка индекса                - isValidIndex, стр. 68
// Перебор: обычный for            - printWithFor,      стр. 78
// Перебор: for-each               - printWithForEach,  стр. 84
// Перебор: Iterator               - printWithIterator, стр. 90
// Сортировка list.sort()          - sortByTitle,  стр. 100
// Сортировка Collections.sort()   - sortByYear,   стр. 104
// Поиск по названию               - findByTitle,  стр. 110
// Фильтрация по жанру             - filterByGenre, стр. 119
// LinkedList: addLast / addFirst  - стр. 131 / 136
// LinkedList: getFirst / removeFirst - стр. 141 / 149
// =====================================================================

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Работа с List: ArrayList для книг и LinkedList для очереди читателей
public class BookListManager {
    private List<Book> books = new ArrayList<>();
    private LinkedList<String> readerQueue = new LinkedList<>();

    // ---------- ArrayList: добавление, получение, изменение, удаление ----------

    public void addBook(Book book) {
        books.add(book);
        System.out.println("add: " + book);
    }

    public Book getBook(int index) {
        if (!isValidIndex(index)) {
            return null;
        }
        return books.get(index);
    }

    public void updateBook(int index, Book newBook) {
        if (!isValidIndex(index)) {
            return;
        }
        Book oldBook = books.set(index, newBook);
        System.out.println("set(" + index + "): " + oldBook.getTitle() + " -> " + newBook.getTitle());
    }

    public void removeBook(int index) {
        if (!isValidIndex(index)) {
            return;
        }
        Book removedBook = books.remove(index);
        System.out.println("remove(" + index + "): " + removedBook.getTitle());
    }

    public int getSize() {
        return books.size();
    }

    // Проверка индекса: он должен быть от 0 до size-1
    private boolean isValidIndex(int index) {
        if (index >= 0 && index < books.size()) {
            return true;
        }
        System.out.println("Error: index " + index + " is out of range (size = " + books.size() + ")");
        return false;
    }

    // ---------- Три способа перебора ----------

    public void printWithFor() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + i + "] " + books.get(i));
        }
    }

    public void printWithForEach() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printWithIterator() {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }

    // ---------- Сортировка ----------

    public void sortByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

    public void sortByYear() {
        Collections.sort(books, Comparator.comparingInt(Book::getYear));
    }

    // ---------- Поиск и фильтрация ----------

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> filterByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    // ---------- LinkedList: очередь читателей на популярную книгу ----------

    public void addReaderToEnd(String name) {
        readerQueue.addLast(name);
        System.out.println("addLast: " + name + " joined the end of the queue");
    }

    public void addReaderToStart(String name) {
        readerQueue.addFirst(name);
        System.out.println("addFirst: " + name + " has a reservation and goes first");
    }

    public void showFirstReader() {
        if (readerQueue.isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        System.out.println("getFirst: next reader is " + readerQueue.getFirst());
    }

    public void giveBookToFirstReader() {
        if (readerQueue.isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        String reader = readerQueue.removeFirst();
        System.out.println("removeFirst: " + reader + " got the book and left the queue");
    }

    public void printQueue() {
        System.out.println("Queue: " + readerQueue);
    }
}
