package physio.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
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

	private final String[] allScopes = new String[]{"admin", "therapist", "patient"};
	private final String[] nonAdmin = new String[]{"therapist","patient"};
	private final String admin = "admin";
	private final String therapist = "therapist";
	private final String patient = "patient";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
            .antMatchers("/test/**").hasAuthority("admin")
            .antMatchers("/users/patients").hasAnyAuthority(therapist, admin)
            .antMatchers("/users/therapists").hasAnyAuthority(allScopes)
            .antMatchers("/users/admins").hasAnyAuthority(admin)
            .antMatchers("/users/**").hasAnyAuthority(allScopes)
            .antMatchers(HttpMethod.POST, "/users/**").hasAnyAuthority(allScopes)
			// TODO: for productive use replace permitAll() with denyAll() and add all paths with scope checks above
            .anyRequest().permitAll()
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
