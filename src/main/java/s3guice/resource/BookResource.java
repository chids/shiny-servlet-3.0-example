package s3guice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s3guice.domain.Book;
import s3guice.service.BookService;

import com.google.inject.Inject;

@Path("/book")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BookResource {

	private Logger log = LoggerFactory.getLogger(BookResource.class);

	@Inject
	BookService bookService;

	@GET
	@Path("example")
	public Book example() {
		log.info("invoked example...");
		Book book = new Book(0, "A Tale of Two Cities", "Charles Dickens", 1859);
		return book;
	}

	@PUT
	public Book add(Book book) {
		log.info("Adding {}", book);
		bookService.add(book);
		return book;
	}

	@GET
	public Book get(@QueryParam("id") int id) {
		log.info("Querying for Book with id={}", id);
		return bookService.get(id);
	}

	@DELETE
	public void delete(@QueryParam("id") int id) {
		log.info("Deleting Book with id={}", id);
		bookService.delete(id);
	}
}
