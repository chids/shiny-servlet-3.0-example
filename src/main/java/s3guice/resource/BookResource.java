package s3guice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import s3guice.domain.Book;

@Path("/book")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BookResource {

	@GET
	@Path("example")
	public Book example() {
		Book book = new Book("A Tale of Two Cities", "Charles Dickens", 1859);
		return book;
	}
}
