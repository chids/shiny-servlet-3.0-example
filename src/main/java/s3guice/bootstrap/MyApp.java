package s3guice.bootstrap;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("")
public class MyApp extends PackagesResourceConfig {
	public MyApp() {
		super("s3guice.resource");
	}
}
