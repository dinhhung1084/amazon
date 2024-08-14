package edu.poly.config;

import edu.poly.domain.Customer;
import edu.poly.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

//    @Autowired
//    CustomerRepository customerRepository;

//    public SecurityConfig(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

//    @Bean
//    BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().permitAll()
                .and().exceptionHandling(exception -> exception
                        .accessDeniedPage("/403")
                );

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            try {
//                Customer customer = customerRepository.findByUsernameAndIsActivatedTrue(username);
//                if (customer == null) {
//                    throw new UsernameNotFoundException(username + " not found");
//                }
//                String role = customer.isAdmin() ? "ADMIN" : "USER";
//                return org.springframework.security.core.userdetails.User
//                        .withUsername(username)
//                        .password(bCryptPasswordEncoder().encode(customer.getPassword()))
//                        .roles(role)
//                        .build();
//            } catch (Exception e) {
//                throw new UsernameNotFoundException(username + " not found");
//            }
//        };
//    }



//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/resources/**"); // Bỏ qua bảo mật cho các tài nguyên tĩnh
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Tạo người dùng với quyền admin
//        UserDetails adminUser = User.withUsername("admin")
//                .password("{noop}password") // {noop} để không mã hóa mật khẩu
//                .authorities("ROLE_ADMIN") // Thiết lập quyền admin
//                .build();
//
//        // Tạo người dùng thông thường
//        UserDetails regularUser = User.withUsername("user")
//                .password("{noop}password")
//                .authorities("ROLE_USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(adminUser, regularUser);
//    }




}



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
