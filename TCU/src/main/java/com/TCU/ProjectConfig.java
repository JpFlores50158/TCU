
package com.TCU;

import com.TCU.service.AyudaService;
import com.TCU.service.BeneficiadoService;
import com.TCU.service.PensionService;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BeneficiadoService beneficiadoService;
     @Autowired
    private AyudaService ayudaService;
     
      @Autowired
    private PensionService pensionService;

    @Bean
    public LocaleResolver localeServer() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");

        return slr;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    public ProjectConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/registro/**", "/logout", "/images/**",
                        "/templates/**", "/js/**", "/webjars/**",
                        "/obra/listado", "/nosotros/**", "/error?continue", "/error", "/actividad/nuevo", "/actividad/guardar", "actividad/exito")
                .permitAll()
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .requestMatchers("/perfil/**", "/beneficiado/**", "/pension/**", "/ayuda/**", "/actividad/**", "/listaEspera/**", "/excel/**")
                .hasAnyRole("ADMIN", "USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

     @PostConstruct
    public void init() {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.getDayOfMonth() == 1) {
           
            beneficiadoService.updateAllBeneficiadosFecha(currentDate);
            ayudaService.updateAllAyudasFecha(currentDate);
             pensionService.updateAllPensionesFecha(currentDate);
        }
    }
}
