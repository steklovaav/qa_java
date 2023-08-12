package com.example;

import java.util.List;

public interface IAnimal {
    public List<String> getFood(String animalKind) throws Exception;
    public String getFamily();
}
