package edu.wctc;

public class MissingNameException extends Exception{
    public MissingNameException(String nameType) {
        super(String.format("%s this field can't be blank. Please try again", nameType));
    }
}
