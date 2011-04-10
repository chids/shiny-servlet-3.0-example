package s3guice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/howdy")
@Produces("text/plain")
public class HelloResource {
	@GET
	public String get() {
		return "Howdy Stranger!";
	}
}
