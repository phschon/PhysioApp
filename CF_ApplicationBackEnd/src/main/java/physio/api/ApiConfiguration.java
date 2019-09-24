package physio.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;

import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;
import com.sap.cloud.security.xsuaa.token.TokenAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class ApiConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	XsuaaServiceConfiguration xsuaaServiceConfiguration;

	private static final Log logger = LogFactory.getLog(ApiConfiguration.class);

	private String isAdmin = "#oauth2.hasScopeMatching('admin')";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
            //.antMatchers("/hello-token/**").hasAuthority("Read") // checks whether it has scope "<xsappId>.Read"
            .antMatchers("/test/**").hasAuthority("admin")
            .anyRequest().denyAll()
        .and()
            .oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(getJwtAuthoritiesConverter());
        // @formatter:on
	}

	Converter<Jwt, AbstractAuthenticationToken> getJwtAuthoritiesConverter() {
		TokenAuthenticationConverter converter = new TokenAuthenticationConverter(xsuaaServiceConfiguration);
		converter.setLocalScopeAsAuthorities(true);
		return converter;
	}
}
