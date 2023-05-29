package de.kaiserpfalzedv.rpg.scheduler.api;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import lombok.NonNull;

public interface GameSession {
   UUID id();

    @NonNull
    OffsetDateTime date();

    @NonNull
    Duration duration();

    @NonNull
    String title();

    @NonNull
    String description();

    @NonNull
    Location location();

    @NonNull
    Player gm();

    @NonNull
    List<? extends Player> players();

}