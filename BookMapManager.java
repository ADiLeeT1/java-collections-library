// ===================== ШПАРГАЛКА: ГДЕ ЧТО ИСКАТЬ =====================
// Map (HashMap) - каталог: ключ = id книги, значение = книга.
// Поле catalog                    - стр. 17
// put() + замена значения ключа   - putBook,    стр. 19
// get()                           - getBook,    стр. 29
// containsKey()                   - containsId, стр. 33
// remove()                        - removeBook, стр. 37
// size()                          - getSize,    стр. 46
// Перебор entrySet()              - printAll,   стр. 50
// =====================================================================

import java.util.HashMap;
import java.util.Map;

// Работа с Map: каталог книг, ключ - id, значение - книга
public class BookMapManager {
    private Map<Integer, Book> catalog = new HashMap<>();

    public void putBook(Book book) {
        Book oldBook = catalog.put(book.getId(), book);
        if (oldBook == null) {
            System.out.println("put: " + book.getId() + " -> " + book.getTitle());
        } else {
            System.out.println("put: " + book.getId() + " -> " + book.getTitle()
                    + " (key already existed, old value " + oldBook.getTitle() + " was replaced)");
        }
    }

    public Book getBook(int id) {
        return catalog.get(id);
    }

    public boolean containsId(int id) {
        return catalog.containsKey(id);
    }

    public void removeBook(int id) {
        Book removedBook = catalog.remove(id);
        if (removedBook == null) {
            System.out.println("remove: " + id + " -> key not found");
        } else {
            System.out.println("remove: " + id + " -> " + removedBook.getTitle());
        }
    }

    public int getSize() {
        return catalog.size();
    }

    public void printAll() {
        for (Map.Entry<Integer, Book> entry : catalog.entrySet()) {
            System.out.println("key " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
