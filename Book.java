// ===================== ШПАРГАЛКА: ГДЕ ЧТО ИСКАТЬ =====================
// Класс сущности "Книга": поля, конструктор, геттеры, toString().
// Поля                 - стр. 18
// Конструктор          - стр. 24
// Геттеры              - стр. 32-48
// toString()           - стр. 53
// equals() (НОВОЕ)     - стр. 60: книги равны, если одинаковый id
// hashCode() (НОВОЕ)   - стр. 69: считается по тому же id
// Демо на защите: выдели строки 58-71 и нажми Ctrl+/
// (закомментировать). Запусти: в разделе 5 копия книги добавится, будет 3 книги
// вместо 2. Снова Ctrl+/ - код вернётся.
// =====================================================================

import java.util.Objects;

// Класс сущности: одна книга в библиотеке
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(int id, String title, String author, String genre, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title=" + title + ", author=" + author
                + ", genre=" + genre + ", year=" + year + "}";
    }

    // Две книги считаются одинаковыми, если у них одинаковый id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book other = (Book) o;
        return id == other.id;
    }

    // У одинаковых книг hashCode обязан совпадать (те же поля, что в equals)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
