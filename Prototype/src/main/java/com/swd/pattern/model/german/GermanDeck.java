package com.swd.pattern.model.german;

import com.swd.pattern.model.Card;
import com.swd.pattern.model.Deck;
import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.german.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class GermanDeck extends Deck {

    public GermanDeck(ICardFactory factory){
        super(factory);
    }

    @Override
    public void generateCards() {
        this.addLeavesCards();
    }

    private void addLeavesCards(){
        for(int i=1; i<=13; i++){
            cards.add(cardFactory.createCard(i, CardSuit.Leaves.toString()));
        }
    }

    public List<Card> getCards(){
        return cards;
    }

    @Override
    public GermanDeck clone() {
        return (GermanDeck) super.clone();
    }

}

