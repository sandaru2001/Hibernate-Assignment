package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId("B001");
        book.setBookName("lushan ponnaya");

        Author author = new Author();
        author.setAuthorId("A001");
        author.setAuthorName("Martin Wickremasinghe");
        author.setBook(book);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(author);
        transaction.commit();
        session.close();
    }
}