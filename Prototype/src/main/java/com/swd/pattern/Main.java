package com.swd.pattern;

import com.swd.pattern.abstr.factory.CardAbstractFactory;
import com.swd.pattern.abstr.factory.CardFactory;
import com.swd.pattern.model.DeckCache;
import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.Card;
import com.swd.pattern.model.DeckType;
import com.swd.pattern.model.american.AmericanDeck;
import com.swd.pattern.model.german.GermanDeck;

import java.util.HashMap;
import java.util.List;

public class Main {



    public static void main(String[] args){

        DeckCache cache = new DeckCache();

        ICardFactory cardFactory = CardFactory.getFactory(DeckType.German);

        GermanDeck deckOriginal = new GermanDeck(cardFactory);
        deckOriginal.generateCards();

        System.out.println("Original deck initiated: " + deckOriginal.getCards().toString());

        //Register object to facilitate cloning
        cache.addDeck("startedDeck", deckOriginal);

        /*
        Using the "startedDeck" as a prototype to create decks with initialized properties
        */
        GermanDeck deckClone = cache.getDeckClone("startedDeck");

        System.out.println("Cloned deck created: " + deckClone.getCards().toString());

        deckOriginal.generateCards();
        System.out.println("Original deck modified: " + deckOriginal.getCards().toString());
        System.out.println("Cloned deck remains unaltered: " + deckClone.getCards().toString());

    }


}
