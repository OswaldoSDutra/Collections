package com.swd.pattern.model.american;

import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.Card;
import com.swd.pattern.model.american.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class AmericanDeck {

    private final ICardFactory cardFactory;
    private final List<Card> cards;

    public AmericanDeck(ICardFactory factory){
        this.cardFactory = factory;
        this.cards = new ArrayList<>();
    }

    public void addSpadesCards(){
        for(int i=1; i<=13; i++){
            cards.add(cardFactory.createCard(i, CardSuit.Spades.toString()));
        }
    }

    public List<Card> getCards(){
        return cards;
    }
}
