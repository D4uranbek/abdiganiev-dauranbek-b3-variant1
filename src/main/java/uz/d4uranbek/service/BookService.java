package uz.d4uranbek.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import uz.d4uranbek.entity.Book;

import java.util.List;

@Service
public class BookService extends BaseService {

    public void add(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Book> query = session.createQuery("from Book", Book.class);
        List<Book> bookList = query.list();
        transaction.commit();
        session.close();
        return bookList;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query from_book = session.createQuery("delete from Book where id=:ID");
        from_book.setParameter("ID", id);
        from_book.executeUpdate();
        transaction.commit();
        session.close();
    }

    public Book getById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Book> query = session.createQuery("from Book where id=:ID", Book.class);
        query.setParameter("ID", id);
        List<Book> bookList = query.list();
        transaction.commit();
        session.close();
        return bookList.get(0);
    }

    public void update(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query from_book = session.createQuery("update Book set title=:TITLE,author=:AUTHOR,price=:PRICE where id=:ID");
        from_book.setParameter("ID", book.getId());
        from_book.setParameter("TITLE", book.getTitle());
        from_book.setParameter("AUTHOR", book.getAuthor());
        from_book.setParameter("PRICE", book.getPrice());
        from_book.executeUpdate();
        transaction.commit();
        session.close();
    }
}
