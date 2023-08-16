package com.example;

import java.util.List;

public interface IAnimal {
    List<String> getFood(String animalKind) throws Exception;
    String getFamily();
}
