package com.alexisdev.StarWarsFilms.obj;

import java.util.List;

public class CharacterListWrapper {

    private List<Character> characters;

    public CharacterListWrapper(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}