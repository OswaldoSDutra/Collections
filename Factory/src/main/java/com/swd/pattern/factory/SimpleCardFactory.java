package com.swd.pattern.factory;

import com.swd.pattern.model.Card;
import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.american.CardSuit;
import com.swd.pattern.model.american.SpadesCard;

public class SimpleCardFactory implements ICardFactory {

    @Override
    public Card createCard(int value, String suit) {

        if(suit.equals(CardSuit.Spades.toString()))
            return new SpadesCard(value);

        return null;
    }
}
