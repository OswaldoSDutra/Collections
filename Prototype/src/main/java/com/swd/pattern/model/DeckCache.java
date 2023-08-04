package com.swd.pattern.model;

import com.swd.pattern.model.german.GermanDeck;

import java.util.HashMap;
import java.util.Map;

public class DeckCache {

    private final Map<String, GermanDeck> cachedDecks;

    public DeckCache(){
        this.cachedDecks = new HashMap<>();
    }

    public void addDeck(String key, GermanDeck deck){
        cachedDecks.put(key, deck);
    }

    public GermanDeck getDeckClone(String key){
        if(cachedDecks.containsKey(key))
            return cachedDecks.get(key).clone();

        return null;
    }

}
