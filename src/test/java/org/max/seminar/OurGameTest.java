package org.max.seminar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.max.seminar.exception.DeckEmptyException;

import java.util.ArrayList;


import static org.max.seminar.type.Ranks.TWO;
import static org.max.seminar.type.Suits.CLUBS;
public class OurGameTest {
    Card checkCard;
    Deck deck;

    @BeforeEach
    void getNewDeck() {
        checkCard = new Card(TWO, CLUBS);
        ArrayList<Card> arrayList = new ArrayList<>();
        arrayList.add(checkCard);
        deck = new Deck(arrayList);
    }

    @Test
    void testGetCardEmptyDeck() {
        //Given
        deck = new Deck(new ArrayList<>());
        //When
        Assertions.assertThrows(DeckEmptyException.class, deck::getCard);
    }

    @Test
    void testGetCardFullDeck() throws DeckEmptyException {
        //Given
        DeckService deckService = new DeckService();
        deck = deckService.getNewDeck();
        Card check = deck.getCards().get(0);
        int size = deck.getCards().size();
        //Then
        Card result = deck.getCard();
        //When
        Assertions.assertEquals(check, result);
        Assertions.assertEquals(size - 1, deck.getCards().size());
    }
    @Test
    void testGetCardWithOneCard() throws DeckEmptyException {
        //Then
        Card result = deck.getCard();

        //When
        Assertions.assertEquals(checkCard, result);
        Assertions.assertEquals(0, deck.getCards().size());
    }
}
