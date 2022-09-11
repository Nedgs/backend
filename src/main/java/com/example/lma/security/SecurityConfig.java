package com.example.lma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login").permitAll();
//        http.authorizeRequests().antMatchers("/all").hasAnyAuthority("ADMIN", "MANAGER");

//      Lister tous les utilisateurs
        http.authorizeRequests().antMatchers("/api/users/all").hasAuthority("ADMIN");

//      Ajouter un utilisateur
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/users/save").hasAuthority("ADMIN");

//      Modifier un utilisateur
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/users/save").hasAuthority("ADMIN");

//      Supprimer un utilisateur
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/users/delete").hasAuthority("ADMIN");

        //      Ajouter une company
        http.authorizeRequests().antMatchers("/api/company/**").hasAnyAuthority("ADMIN", "USER");

        //      edit une company
        http.authorizeRequests().antMatchers("/api/companys/**").hasAnyAuthority("ADMIN", "USER");

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
