package com.swd.pattern.abstr.factory;

import com.swd.pattern.model.Card;
import com.swd.pattern.model.german.CardSuit;
import com.swd.pattern.model.german.LeavesCard;

public class GermanCardFactory extends CardAbstractFactory{

    @Override
    public Card createCard(int value, String suit) {
        if(suit.equals(CardSuit.Leaves.toString()))
            return new LeavesCard(value);

        return null;
    }
}
