package com.swd.pattern.model.american;

import com.swd.pattern.model.Deck;
import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.Card;
import com.swd.pattern.model.american.CardSuit;
import com.swd.pattern.model.german.GermanDeck;

import java.util.ArrayList;
import java.util.List;

public class AmericanDeck extends Deck {

    public AmericanDeck(ICardFactory factory) {
        super(factory);
    }

    @Override
    public void generateCards() {
        this.addSpadesCards();
    }

    private void addSpadesCards(){
        for(int i=1; i<=13; i++){
            this.cards.add(this.cardFactory.createCard(i, CardSuit.Spades.toString()));
        }
    }

    public List<Card> getCards(){
        return this.cards;
    }

    @Override
    public AmericanDeck clone() {
        return (AmericanDeck) super.clone();
    }
}
