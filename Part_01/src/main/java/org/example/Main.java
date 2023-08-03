package org.example;

import org.example.Entity.Book;
import org.example.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        create New object in book type
        Book book1 = new Book("B001", "Sherlock Hormes");
        Book book2 = new Book("B002", "Harry Potter");

//        Get the Hibernate session instance from the factory configuration.
        Session session = FactoryConfiguration.getInstance().getSession();

//        Begin a new transaction
        Transaction transaction = session.beginTransaction();

        /*Save the "book" object to the database table.
        * The "persist" method is used to save the object, making it persistence.
        * The book object should have been properly mapped as an entity in Hibernate.*/
        session.persist(book1);
        session.persist(book2);

        /* Commit the transaction to make the changes permanent in the database.*/
        transaction.commit();

        System.out.println("Book save successfully");

        Transaction transaction1 = session.beginTransaction();

        Book book3 = session.get(Book.class,"B001");

        System.out.println("Retrieve the book successfully");

        if (book3!=null){
            book3.setName("Merlin");

            transaction1.commit();

            System.out.println("Update the book successfully");
        }

        Transaction transaction2 = session.beginTransaction();

        session.remove(book1);
        transaction2.commit();

        System.out.println("Remove the book successfully");
    }
}