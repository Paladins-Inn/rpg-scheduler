package de.kaiserpfalzedv.rpg.scheduler.core.model;

import java.time.Duration;
import java.util.UUID;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.Guild;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table(
    name = "LOCATIONS", 
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"serverName", "channelName"})
    }
)
@Jacksonized
@Builder(toBuilder = true)
@Getter
@Accessors(fluent = true, prefix = "")
@EqualsAndHashCode(of = "id")
@ToString(of = {"id"})
public class Location implements de.kaiserpfalzedv.rpg.scheduler.api.Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String serverName;
    private String channelName;

    public void play() {
        GatewayDiscordClient client = DiscordClient.create(channelName).gateway().login().block(Duration.ofMinutes(2));

        Guild guild;
    }
}
