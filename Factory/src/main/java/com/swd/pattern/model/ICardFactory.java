package com.swd.pattern.model;

import com.swd.pattern.model.Card;
import com.swd.pattern.model.american.CardSuit;

public interface ICardFactory {
    Card createCard(int value, String suit);
}
