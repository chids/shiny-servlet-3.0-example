package s3guice.bootstrap;

import javax.servlet.annotation.WebListener;

import s3guice.resource.BookResource;
import s3guice.service.BookService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

@WebListener
public class MyGuiceListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {
				install(new JpaPersistModule("myPersistenceUnit"));

				bind(BookResource.class);
				bind(BookService.class);

				filter("/*").through(PersistFilter.class);
				serve("/*").with(GuiceContainer.class);
			}
		});
	}
}
