package edu.poly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



//
//
//import edu.poly.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends SecurityFilterChain {
//
//    @Autowired
//    CustomerService customerService;
//
//
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user")
//                .password(bCryptPasswordEncoder.encode("userPass"))
//                .roles("USER")
//                .build());
//        manager.createUser(User.withUsername("admin")
//                .password(bCryptPasswordEncoder.encode("adminPass"))
//                .roles("USER", "ADMIN")
//                .build());
//        return manager;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/site/home","/account/login/**","/account/register/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//
//        http.exceptionHandling().accessDeniedPage("/account/login");
//
//        http.formLogin()
//                .loginPage("/account/login")
//                .loginProcessingUrl("/account/login/check")
//                .defaultSuccessUrl("/account/home",false)
//                .failureUrl("/account/login");
//
//        http.logout().logoutUrl("/account/logout")
//        .logoutSuccessUrl("/account/login");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username ->{}
//        try {
//            Customer customer = customerRepository.findByUsernameAndIsActivatedTrue(username);
//            String password = customer.getPassword();
//            boolean roles = customer.isAdmin();
//            String role;
//            if (roles){
//                role = "ADMIN";
//            }else{
//                role = "USER";
//            }
//            return User.withUsername(username).password(bCryptPasswordEncoder.encode(password)).roles(role).build();
//        }catch (Exception e){
//            throw new UsernameNotFoundException(username + "User not found");
//        });
//    }
//
//}
