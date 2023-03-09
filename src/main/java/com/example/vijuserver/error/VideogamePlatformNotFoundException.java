package com.example.vijuserver.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VideogamePlatformNotFoundException extends RuntimeException{

    public VideogamePlatformNotFoundException(){
        super("No se puede encontrar ninguna unión entre videojuego y plataforma");
    }

    public VideogamePlatformNotFoundException(Long id){
        super("No se puede encontrar la unión de videojuego y plataforma con la ID: " + id);
    }
}
