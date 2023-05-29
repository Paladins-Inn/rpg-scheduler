package de.kaiserpfalzedv.rpg.scheduler.core.model;

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
public class Location implements de.kaiserpfalzedv.rpg.scheduler.api.Location {
    @Default
    private UUID id = UUID.randomUUID();

}
