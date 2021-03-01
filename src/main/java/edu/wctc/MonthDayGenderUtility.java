package edu.wctc;

import java.time.DateTimeException;
import java.time.LocalDate;

public class MonthDayGenderUtility {
    private final int HMALE = 0;
    private final int HFEMALE = 500;
    private final char CMALE = 'M';
    private final char CFEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode)
            throws UnknownGenderCodeException, InvalidBirthdayException {
        if (Character.toUpperCase(genderCode) != CMALE && Character.toUpperCase(genderCode) != CFEMALE) {
            throw new UnknownGenderCodeException(genderCode);
        } else {
            try {
                LocalDate birthDate = LocalDate.of(year, month, day);
                int genderMod = Character.toUpperCase(genderCode) == 'M'
                        ? HMALE
                        : HFEMALE;

                return (month - 1) * 40 + day + genderMod;

            } catch (DateTimeException dte) {
                throw new InvalidBirthdayException(year, month, day);
            }
        }
    }




}
