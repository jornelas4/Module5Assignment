package edu.wctc;
import org.apache.commons.codec.language.Soundex;

public class LastNameUtility {
    private Soundex soundex = new Soundex();

    public String encodeLastName(String lastName) throws MissingNameException{
        if(lastName.isBlank()){
            throw new MissingNameException("Last name");
        } else {
            return soundex.encode(lastName);
        }
    }


}
