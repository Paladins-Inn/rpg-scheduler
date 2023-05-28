package de.kaiserpfalzedv.rpg.scheduler;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
@Getter
@Accessors(fluent = true, prefix = "")
@EqualsAndHashCode(of = "id")
@ToString(of = {"id"})
public class Player {
    @Default
    private UUID id = UUID.randomUUID();
}
