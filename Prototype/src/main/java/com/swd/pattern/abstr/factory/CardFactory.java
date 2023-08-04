package com.swd.pattern.abstr.factory;

import com.swd.pattern.model.DeckType;

public class CardFactory {
    public static CardAbstractFactory getFactory(DeckType factoryType) {

        if(factoryType.equals(DeckType.American))
            return new AmericanCardFactory();

        if(factoryType.equals(DeckType.German))
            return new GermanCardFactory();

        return null;
    }
}
