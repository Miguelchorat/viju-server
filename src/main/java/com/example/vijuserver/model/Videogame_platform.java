package com.example.vijuserver.model;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Videogame_platform {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "videogame_id")
    private Videogame videogame;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;
    private LocalDateTime created_at;
}