//package config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.Customizer
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.web.SecurityFilterChain
//import org.springframework.web.cors.CorsConfiguration
//import org.springframework.web.cors.CorsConfigurationSource
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource
//
//@Configuration
//@EnableWebSecurity
//class SecurityConfiguration {
//
//    @Bean
//    fun appSecurity(http: HttpSecurity): SecurityFilterChain {
//        http
//            .cors(Customizer.withDefaults())
//            .authorizeHttpRequests() { requests -> requests.anyRequest().authenticated() }
//            .formLogin(Customizer.withDefaults())
//        return http.build()
//    }
//
//    @Bean
//    fun corsConfigurationSource(): CorsConfigurationSource {
//        var source: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
//        var config: CorsConfiguration = CorsConfiguration()
//
//        config.addAllowedHeader("*")
//        config.addAllowedMethod("*")
//        config.addAllowedOrigin("http://127.0.0.1:5173")
//        config.allowCredentials
//        source.registerCorsConfiguration("/**", config)
//        return source
//    }
//}