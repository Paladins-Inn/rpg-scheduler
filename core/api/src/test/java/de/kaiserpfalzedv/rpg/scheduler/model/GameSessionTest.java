package de.kaiserpfalzedv.rpg.scheduler.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.kaiserpfalzedv.rpg.scheduler.GameSession;
import de.kaiserpfalzedv.rpg.scheduler.Location;
import de.kaiserpfalzedv.rpg.scheduler.Player;

public class GameSessionTest {
    private static final UUID ID = UUID.randomUUID();

    private static final OffsetDateTime DATE = OffsetDateTime.now(ZoneId.of("UTC"));
    private static final Duration DURATION = Duration.ofHours(4L);
    private static final String TITLE = "Default Title";
    private static final String DESCRIPTION = "Description";

    private static final Player GM = Player.builder()
            .build();

    private static final List<Player> PLAYERS = List.of(
        Player.builder().build(),
        Player.builder().build()
    );

    private static final Location LOCATION = Location.builder().build();


    private GameSession session;

    @BeforeEach
    public void constructDefaultGameSessionBuilder() {
        session = GameSession.builder()
            .id(ID)
            .date(DATE)
            .duration(DURATION)
            .title(TITLE)
            .description(DESCRIPTION)
            .location(LOCATION)
            .gm(GM)
            .players(PLAYERS)
            .build();
    }

    @Test
    public void ResultContainsValidIdWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(ID, session.id(), "The ID is wrong");
    }

    @Test
    public void ResultContainsValidDateWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(DATE, session.date(), "The date is not valid");
    }

    @Test
    public void ResultContainsValidDurationWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(DURATION, session.duration(), "The duration is wrong");
    }

    @Test
    public void ResultContainsValidTitleWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(TITLE, session.title(), "The title is wrong");
    }

    @Test
    public void ResultContainsValidDescriptionWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(DESCRIPTION, session.description(), "The description is wrong");
    }

    @Test
    public void ResultContainsValidGameMasterWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(GM, session.gm(), "The GM is wrong");
    }

    @Test
    public void ResultContainsValidPlayersListWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(PLAYERS, session.players(), "The list of players is wrong");
    }

    @Test
    public void ResultContainsValidLocationWhenDefaultTestGameSessionIsConstructed() {
        assertEquals(LOCATION, session.location(), "The location is wrong");
    }

    @Test
    public void CopiesWithSameIdAreEqual() {
        GameSession copy = session.toBuilder()
                .title("Other Title")
                .build();

        assertTrue(session.equals(copy), "The two game sessions should be considered equal!");
    }

    @Test
    public void CopiesWithDifferentIdsAreNotEqual() {
        GameSession copy = session.toBuilder()
                .id(UUID.randomUUID())
                .build();

        assertFalse(session.equals(copy), "The two game sessions should not be equal");
    }
}
