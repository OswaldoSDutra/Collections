package com.swd.pattern.abstr.factory;

import com.swd.pattern.model.Card;
import com.swd.pattern.model.ICardFactory;

public abstract class CardAbstractFactory implements ICardFactory {

    public abstract Card createCard(int value, String suit);
}
