package org.max.home;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class MyGameTest {
    List<Door> doors;
    Player player;
    Game game;

    @BeforeEach
    //на самом деле тут можно использоваь @BeforeAll, т.к. doors не меняется в течение всех тестов.
    void initDoors() {
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
    }

    @Test
    void testRoundWithoutChangingSelectionGetLose() {
        //given
        player = new Player("Player1", false);
        game = new Game(player, doors);
        //when
        boolean result = game.round(1).isPrize();
        //then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertFalse(result);

    }

    @Test
    void testRoundWithoutChangingSelectionGetWin() {
        //given
        player = new Player("Player1", false);
        game = new Game(player, doors);
        //when
        boolean result = game.round(2).isPrize();
        //then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertTrue(result);
    }

    @Test
    void testRoundWithChangingSelectionGetLose() {
        //given
        player = new Player("Player1", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(2).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertFalse(result);
    }

    @Test
    void testRoundWithChangingSelectionGetWin() {
        //given
        player = new Player("Player1", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(1).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertTrue(result);
    }

}
