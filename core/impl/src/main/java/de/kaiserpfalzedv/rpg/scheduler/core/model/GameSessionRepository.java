package de.kaiserpfalzedv.rpg.scheduler.core.model;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface GameSessionRepository extends ReactiveCrudRepository<GameSession, UUID> {
    @Query("SELECT s FROM GameSession s JOIN Location l WHERE l.id := location")
    Flux<GameSession> findByLocation(UUID location);

    Flux<GameSession> findByGM(Player GM);

    @Query("SELECT s FROM GameSession s JOIN Player p WHERE p.id = :player")
    Flux<GameSession> findByPlayer(UUID player);
}
