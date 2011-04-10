package s3guice.bootstrap;

import javax.servlet.annotation.WebListener;

import s3guice.resource.HelloResource;

import com.google.inject.Guice;
import com.google.inject.Injector;
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
				bind(HelloResource.class);

				serve("/*").with(GuiceContainer.class);
			}
		});
	}
}
