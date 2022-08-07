package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
     * Secured /notices - Not Secured /contact - Not Secured
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * Default configurations which will secure all the requests
         */


          http .authorizeRequests() .anyRequest().authenticated() .and()
          .formLogin().and() .httpBasic();


        /**
         * Custom configurations as per our requirement
         */

        /*
         * http .authorizeRequests() .antMatchers("/myAccount").authenticated()
         * .antMatchers("/myBalance").authenticated()
         * .antMatchers("/myLoans").authenticated()
         * .antMatchers("/myCards").authenticated() .antMatchers("/notices").permitAll()
         * .antMatchers("/contact").permitAll() .and() .formLogin().and() .httpBasic();
         */

        /**
         * Configuration to deny all the requests
         */

        /*
         * http .authorizeRequests() .anyRequest().denyAll() .and() .formLogin().and()
         * .httpBasic();
         */

        /**
         * Configuration to permit all the requests
         */

       /* http .authorizeRequests() .anyRequest().permitAll().and() .formLogin().and()
                .httpBasic();
        */


    }



    /**
     * Provide our own users
     */
    /*
     * @Override protected void configure(AuthenticationManagerBuilder auth) throws
     * Exception {
     * auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
     * ("admin").and(). withUser("user").password("12345").authorities("read").and()
     * .passwordEncoder(NoOpPasswordEncoder.getInstance()); }
     */





    /*
     * @Override protected void configure(AuthenticationManagerBuilder auth) throws
     * Exception { InMemoryUserDetailsManager userDetailsService = new
     * InMemoryUserDetailsManager(); UserDetails user =
     * User.withUsername("admin").password("12345").authorities("admin").build();
     * UserDetails user1 =
     * User.withUsername("user").password("12345").authorities("read").build();
     * userDetailsService.createUser(user); userDetailsService.createUser(user1);
     * auth.userDetailsService(userDetailsService); }
     */



    /**
     * to Use JdbcUserDetailsManager
     */
    /*
     * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
     * return new JdbcUserDetailsManager(dataSource); }
     */


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
