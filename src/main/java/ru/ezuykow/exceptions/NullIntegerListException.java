package ru.ezuykow.exceptions;

public class NullIntegerListException extends RuntimeException{

    public NullIntegerListException() {
        super("StringList in parameter must be not-null!");
    }
}
