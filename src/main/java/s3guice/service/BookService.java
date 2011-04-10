package s3guice.service;

import javax.persistence.EntityManager;

import s3guice.domain.Book;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class BookService {

	@Inject
	EntityManager em;

	@Transactional
	public void add(Book book) {
		em.persist(book);
	}

	@Transactional
	public void delete(int id) {
		Book book = em.find(Book.class, new Integer(id));
		if (book != null) {
			em.remove(book);
		}
	}

	public Book get(int id) {
		Book book = em.find(Book.class, new Integer(id));
		return book;
	}
}
