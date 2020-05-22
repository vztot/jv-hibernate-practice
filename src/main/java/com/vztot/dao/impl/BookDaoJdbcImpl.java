package com.vztot.dao.impl;

import com.vztot.dao.BookDao;
import com.vztot.exception.DataProcessingException;
import com.vztot.lib.Dao;
import com.vztot.model.Author;
import com.vztot.model.Book;
import com.vztot.model.Genre;
import com.vztot.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class BookDaoJdbcImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert book entity: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            Predicate predicate = criteriaBuilder.equal(root.get("title"), title);
            Book books = session.createQuery(query.where(predicate)).getSingleResult();
            return books;
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Cant fetch the books by title", e);
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            Predicate predicate = criteriaBuilder.equal(root.get("author"), author);
            List<Book> books = session.createQuery(query.where(predicate)).getResultList();
            return books;
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Cant fetch the books by author", e);
        }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            Predicate predicate = criteriaBuilder.equal(root.get("genre"), genre);
            List<Book> books = session.createQuery(query.where(predicate)).getResultList();
            return books;
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Cant fetch the books by genre", e);
        }
    }

    @Override
    public List<Book> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Book> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Book.class);
            criteriaQuery.from(Book.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all books", e);
        }
    }
}
