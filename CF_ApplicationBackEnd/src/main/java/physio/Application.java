package physio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
		System.setProperty("org.apache.catalina.connector.CoyoteAdapter.ALLOW_BACKSLASH", "true");

		SpringApplication.run(Application.class, args);
	}
}
