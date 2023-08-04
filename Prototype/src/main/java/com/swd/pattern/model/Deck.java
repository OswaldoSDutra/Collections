package com.swd.pattern.model;

import com.swd.pattern.model.german.GermanDeck;

import java.util.ArrayList;
import java.util.List;

public abstract class Deck implements Cloneable{

    protected final ICardFactory cardFactory;
    protected List<Card> cards;

    public Deck(ICardFactory factory){
        this.cardFactory = factory;
        this.cards = new ArrayList<>();
    }

    //Copy constructor used to implement de prototype pattern
    protected Deck(List<Card> cards, ICardFactory factory){
        this.cards = cards;
        this.cardFactory = factory;
    }

    public abstract void generateCards();

    @Override
    public Deck clone() {
        try {
            Deck clone = (Deck) super.clone();

            //Deep copy of the cards allowing separated card list for each instance
            clone.cards = new ArrayList<>(this.cards);

            return clone;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
