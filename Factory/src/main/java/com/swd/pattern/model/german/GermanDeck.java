package com.swd.pattern.model.german;

import com.swd.pattern.model.Card;
import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.german.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class GermanDeck {

    private final ICardFactory cardFactory;
    private final List<Card> cards;

    public GermanDeck(ICardFactory factory){
        this.cardFactory = factory;
        this.cards = new ArrayList<>();
    }

    public void addLeavesCards(){
        for(int i=1; i<=13; i++){
            cards.add(cardFactory.createCard(i, CardSuit.Leaves.toString()));
        }
    }

    public List<Card> getCards(){
        return cards;
    }

}

