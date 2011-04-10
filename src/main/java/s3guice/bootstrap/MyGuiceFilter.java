package s3guice.bootstrap;

import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyGuiceFilter extends com.google.inject.servlet.GuiceFilter {

}
