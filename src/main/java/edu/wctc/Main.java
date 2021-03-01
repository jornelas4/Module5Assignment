package edu.wctc;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Please enter your first name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Please enter your  middle initial: ");
        String middleInitial = keyboard.nextLine();

        System.out.print("Please enter your last name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Please enter DOB year: ");
        int year = Integer.parseInt(keyboard.nextLine());

        System.out.print("Please enter DOB  month (1 - 12): ");
        int month = Integer.parseInt(keyboard.nextLine());

        System.out.print("Please the DOB day ( 1 - 28/31): ");
        int day = Integer.parseInt(keyboard.nextLine());

        System.out.print("Please enter your gender (M or F):" + "\n");
        char genderCode = keyboard.next().charAt(0);

        try {
            DriverLicense driversLicense = new DriverLicense();

            FirstNameUtility firstNameUtility = new FirstNameUtility();
            driversLicense.setFirstNameMiddleInitial(firstNameUtility.encodeFirstName(firstName, middleInitial));

            LastNameUtility lastNameUtility = new LastNameUtility();
            driversLicense.setSoundexCode(lastNameUtility.encodeLastName(lastName));

            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();
            driversLicense.setBirthMonthDayGender(monthDayGenderUtility.encodeMonthDayGender(year, month, day, genderCode));

            driversLicense.setBirthYear(year);

            driversLicense.setOverflow(0);

            WisconsinFormatter wisconsinFormatter = new WisconsinFormatter();
            FloridaFormatter floridaFormatter = new FloridaFormatter();

            System.out.printf("Wisconsin driver license is %s%n", wisconsinFormatter.formatLicenseNumber(driversLicense));
            System.out.printf("Florida driver license is  %s%n", floridaFormatter.formatLicenseNumber(driversLicense));
        } catch (MissingNameException | UnknownGenderCodeException | InvalidBirthdayException e) {
            System.out.println(e.getMessage());
        }
    }

}
