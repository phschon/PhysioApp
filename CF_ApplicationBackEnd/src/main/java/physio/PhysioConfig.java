package physio;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import physio.database.controller.UserRepository;
import physio.database.entities.User;

@Configuration
@EnableCaching
@Getter
@ComponentScan(basePackages = "physio")
public class PhysioConfig {

	private static final Log logger = LogFactory.getLog(PhysioConfig.class);

	private String test;

	public PhysioConfig() throws IOException {
		logger.info("Start application.");
		test = "test";
		String admin = "   {\n" + "        \"id\": \"123\",\n" + "        \"email\": \"123@123.de\",\n" + "        \"role\": \"a\",\n" + "        \"firstName\": \"test\",\n" + "        \"lastName\": \"name\",\n" + "        \"address\": \"address\",\n" + "        \"imageUrl\": \"www.de\"\n" + "    }";

	}

}
