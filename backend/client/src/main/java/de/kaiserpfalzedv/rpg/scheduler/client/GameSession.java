package de.kaiserpfalzedv.rpg.scheduler;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.Builder.Default;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
@Getter
@Accessors(fluent = true, prefix = "")
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "date", "duration", "title"})
public class GameSession {
    @Default
    private UUID id = UUID.randomUUID();

    @NonNull
    private OffsetDateTime date;
    @NonNull
    private Duration duration;

    @NonNull
    private String title;
    @NonNull
    private String description;

    @NonNull
    private Location location;

    @NonNull
    private Player gm;
    @NonNull
    private List<Player> players;
}
