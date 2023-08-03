package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId("B001");
        book.setBookName("Udarasan");

        Book book1 = new Book();
        book1.setBookId("B002");
        book1.setBookName("Thor");

        Author author = new Author();
        author.setAuthorId("A001");
        author.setAuthorName("Martin");

        Author author1 = new Author();
        author1.setAuthorId("A002");
        author1.setAuthorName("Amil");

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        ArrayList<Author> authorList = new ArrayList<>();
        authorList.add(author);
        authorList.add(author1);

        book.setAuthors(authorList);
        book1.setAuthors(authorList);

        author.setBooks(bookList);
        author1.setBooks(bookList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(book1);
        session.persist(author);
        session.persist(author1);

        transaction.commit();
        session.close();
    }
}