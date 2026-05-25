package com.example.demo.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", "dt14hydgd",
                        "api_key", "844125252953251",
                        "api_secret", "oC-9HU-OvANierDePy0YBT4ond4",
                        "secure", true
                )
        );
    }
}
