package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId("B001");
        book.setBookName("Black Tiger");

        Book book1 = new Book();
        book1.setBookId("B002");
        book1.setBookName("Red Tiger");

        Author author = new Author();
        author.setAuthorId("A001");
        author.setAuthorName("Arthor Doili");

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);
        author.setBook(bookList);

        book.setAuthor(author);
        book1.setAuthor(author);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(book1);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}