package com.example.university.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This type serves as a base class for extensions of the {@code WebSecurityConfigurerAdapter} and provides a default
 * configuration. <br/>
 * Security configuration is based on {@link WebSecurityConfigurerAdapter}. This configuration is by purpose designed
 * most simple for two channels of authentication: simple login form and rest-url.
 */
@Configuration
@EnableWebSecurity
@Profile("!junit")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * Configure spring security to enable any request
   */
  @Override
  public void configure(HttpSecurity http) throws Exception {

    http.cors().and().csrf().disable()//
        .authorizeRequests()//
        .anyRequest().permitAll();

  }

}
