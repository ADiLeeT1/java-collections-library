// ===================== ШПАРГАЛКА: ГДЕ ЧТО ИСКАТЬ =====================
// Тема 2 "Библиотека": коллекции List, LinkedList, Set, Map.
// IntelliJ: Ctrl+G - перейти к строке, Ctrl+F - поиск по файлу,
//           Ctrl+клик по названию метода - открыть сам метод.
//
// Раздел в консоли               -> файл: методы
// 1. ArrayList add/get/set/remove -> BookListManager: addBook, getBook, updateBook, removeBook, isValidIndex
// 2. for / for-each / Iterator    -> BookListManager: printWithFor, printWithForEach, printWithIterator
// 3. LinkedList (очередь)         -> BookListManager: addReaderToEnd, addReaderToStart, showFirstReader, giveBookToFirstReader
// 4. HashSet (жанры)              -> BookSetManager: addGenre, removeGenre, hasGenre
// 5. equals() и hashCode()        -> Book: equals, hashCode; BookSetManager: addUniqueBook
// 6. HashMap (каталог по ID)      -> BookMapManager: putBook, getBook, containsId, removeBook, printAll
// 7. Сортировка (Comparator)      -> BookListManager: sortByTitle, sortByYear
// 8. Поиск и фильтрация           -> BookListManager: findByTitle, filterByGenre
// 9. Проверка ввода               -> Main: readInt, readText
// 10. Почему List, Set, Map       -> конец main() и файл README.md
//
// Разделы в этом файле: 1 - стр. 37, 2 - стр. 53, 3 - стр. 62, 4 - стр. 73, 5 - стр. 89,
//                       6 - стр. 100, 7 - стр. 120, 8 - стр. 129, 9 - стр. 136, 10 - стр. 146
// readInt - стр. 179, readText - стр. 196
// =====================================================================

import java.util.List;
import java.util.Scanner;

// Главный класс: запускает демонстрацию всех операций
public class Main {
    public static void main(String[] args) {
        // Тестовые книги
        Book b1 = new Book(1, "Fahrenheit 451", "Ray Bradbury", "Dystopia", 1953);
        Book b2 = new Book(2, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937);
        Book b3 = new Book(3, "Crime and Punishment", "Fyodor Dostoevsky", "Classic", 1866);
        Book b4 = new Book(4, "Dune", "Frank Herbert", "Sci-Fi", 1965);
        Book b5 = new Book(5, "Brave New World", "Aldous Huxley", "Dystopia", 1932);
        Book b6 = new Book(6, "War and Peace", "Leo Tolstoy", "Classic", 1869);

        // 1. ArrayList
        printHeader("1. ArrayList: add, get, set, remove, size");
        BookListManager listManager = new BookListManager();
        listManager.addBook(b1);
        listManager.addBook(b2);
        listManager.addBook(b3);
        listManager.addBook(b4);
        listManager.addBook(b5);
        listManager.addBook(b6);
        System.out.println("size: " + listManager.getSize());
        printResult("get(1)", listManager.getBook(1));
        printResult("get(10)", listManager.getBook(10)); // неверный индекс
        listManager.updateBook(3, new Book(7, "Foundation", "Isaac Asimov", "Sci-Fi", 1951));
        listManager.removeBook(1);
        System.out.println("size after remove: " + listManager.getSize());

        // 2. Три способа перебора
        printHeader("2. Iterating the list: for, for-each, Iterator");
        System.out.println("-- for --");
        listManager.printWithFor();
        System.out.println("-- for-each --");
        listManager.printWithForEach();
        System.out.println("-- Iterator --");
        listManager.printWithIterator();

        // 3. LinkedList
        printHeader("3. LinkedList: queue of readers for a popular book");
        listManager.addReaderToEnd("Aidar");
        listManager.addReaderToEnd("Dana");
        listManager.addReaderToEnd("Timur");
        listManager.addReaderToStart("Madina");
        listManager.printQueue();
        listManager.showFirstReader();
        listManager.giveBookToFirstReader();
        listManager.printQueue();

        // 4. HashSet со строками
        printHeader("4. HashSet: unique genres");
        BookSetManager setManager = new BookSetManager();
        setManager.addGenre(b1.getGenre());
        setManager.addGenre(b2.getGenre());
        setManager.addGenre(b3.getGenre());
        setManager.addGenre(b4.getGenre());
        setManager.addGenre(b5.getGenre()); // Dystopia - повтор
        setManager.addGenre(b6.getGenre()); // Classic - повтор
        setManager.printGenres();
        System.out.println("contains(Classic): " + setManager.hasGenre("Classic"));
        System.out.println("contains(Horror): " + setManager.hasGenre("Horror"));
        setManager.removeGenre("Sci-Fi");
        setManager.removeGenre("Horror");
        setManager.printGenres();

        // 5. HashSet с объектами Book: зачем нужны equals() и hashCode()
        printHeader("5. HashSet with books: equals() and hashCode()");
        Book copyOfB1 = new Book(1, "Fahrenheit 451", "Ray Bradbury", "Dystopia", 1953);
        System.out.println("b1 == copyOfB1: " + (b1 == copyOfB1));
        System.out.println("b1.equals(copyOfB1): " + b1.equals(copyOfB1));
        System.out.println("hashCode: " + b1.hashCode() + " and " + copyOfB1.hashCode());
        setManager.addUniqueBook(b1);
        setManager.addUniqueBook(b2);
        setManager.addUniqueBook(copyOfB1); // не добавится: это дубликат b1
        System.out.println("books in set: " + setManager.getUniqueBooksCount());

        // 6. HashMap
        printHeader("6. HashMap: catalog, key = book ID");
        BookMapManager mapManager = new BookMapManager();
        mapManager.putBook(b1);
        mapManager.putBook(b2);
        mapManager.putBook(b3);
        mapManager.putBook(b4);
        mapManager.putBook(b5);
        mapManager.putBook(b6);
        printResult("get(3)", mapManager.getBook(3));
        printResult("get(42)", mapManager.getBook(42));
        System.out.println("containsKey(4): " + mapManager.containsId(4));
        System.out.println("containsKey(42): " + mapManager.containsId(42));
        mapManager.putBook(new Book(2, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954));
        System.out.println("size (unchanged): " + mapManager.getSize());
        mapManager.removeBook(5);
        mapManager.removeBook(42);
        System.out.println("-- entrySet() --");
        mapManager.printAll();

        // 7. Сортировка
        printHeader("7. Sorting the list");
        listManager.sortByTitle();
        System.out.println("-- by title (A-Z) --");
        listManager.printWithForEach();
        listManager.sortByYear();
        System.out.println("-- by year (old -> new) --");
        listManager.printWithForEach();

        // 8. Поиск и фильтрация
        printHeader("8. Search and filter");
        printResult("search 'war and peace'", listManager.findByTitle("war and peace"));
        printResult("search 'Harry Potter'", listManager.findByTitle("Harry Potter"));
        System.out.println("filter genre = Dystopia:");
        printBooks(listManager.filterByGenre("Dystopia"));

        // 9. Ввод пользователя с проверкой
        printHeader("9. User input (with validation)");
        Scanner scanner = new Scanner(System.in);
        int id = readInt(scanner, "Enter book ID to find in the catalog (1-100): ", 1, 100);
        printResult("Book with ID " + id, mapManager.getBook(id));
        String genre = readText(scanner, "Enter a genre to filter the list (e.g. Classic): ");
        System.out.println("Books with genre " + genre + ":");
        printBooks(listManager.filterByGenre(genre));
        scanner.close();

        // 10. Почему выбраны именно эти коллекции
        printHeader("10. Why these collections");
        System.out.println("ArrayList  - books keep their order and can be taken by index");
        System.out.println("LinkedList - fast add/remove at the start and end, good for a queue");
        System.out.println("HashSet    - genres must not repeat, duplicates are ignored");
        System.out.println("HashMap    - fast search of a book by its unique ID (key -> value)");
    }

    // ---------- Вспомогательные методы ----------

    private static void printHeader(String title) {
        System.out.println();
        System.out.println("===== " + title + " =====");
    }

    private static void printResult(String label, Book book) {
        if (book == null) {
            System.out.println(label + ": not found");
        } else {
            System.out.println(label + ": " + book);
        }
    }

    private static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found");
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Читает целое число от min до max. При ошибке просит ввести снова
    private static int readInt(Scanner scanner, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(line);
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Error: enter a number from " + min + " to " + max);
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + line + "' is not a whole number");
            }
        }
    }

    // Читает непустой текст. При пустом вводе просит ввести снова
    private static String readText(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("Error: the text cannot be empty");
        }
    }
}
