package com.swd.pattern;

import com.swd.pattern.abstr.factory.CardAbstractFactory;
import com.swd.pattern.abstr.factory.CardFactory;
import com.swd.pattern.factory.SimpleCardFactory;
import com.swd.pattern.model.ICardFactory;
import com.swd.pattern.model.Card;
import com.swd.pattern.model.DeckType;
import com.swd.pattern.model.american.AmericanDeck;
import com.swd.pattern.model.german.GermanDeck;

import java.util.List;

public class Main {

    public static void main(String[] args){

        //Using basic factory
        System.out.println("Using basic factory, only one factory exists.");
        createDeckWithSimpleFactory();

        //Using basic factory
        System.out.println("Using abstract factory, client should decide which type of factory to use.");
        createDeckWithAbstractFactory();
    }

    //Use basic factory for subclassed that do not need different types
    public static void createDeckWithSimpleFactory(){
        ICardFactory cardFactory = new SimpleCardFactory();

        AmericanDeck deck = new AmericanDeck(cardFactory);
        deck.addSpadesCards();

        List<Card> cards = deck.getCards();

        System.out.println(cards.toString());
    }

    //User abstract factory for subclasses that do require type variants
    public static void createDeckWithAbstractFactory(){
        CardAbstractFactory cardFactory = CardFactory.getFactory(DeckType.German);

        GermanDeck deck = new GermanDeck(cardFactory);
        deck.addLeavesCards();

        List<Card> cards = deck.getCards();

        System.out.println(cards.toString());
    }
}
