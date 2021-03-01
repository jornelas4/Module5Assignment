package edu.wctc;

public class FloridaFormatter implements DriverLicenseFormatter {


    @Override
    public String formatLicenseNumber(DriverLicense driverLicense) {
        String driverNumber = "";
        driverNumber += driverLicense.getSoundexCode() + "-";
        driverNumber += String.format("%03d", driverLicense.getFirstNameMiddleInitial()) + "-";
        driverNumber += Integer.toString(driverLicense.getBirthYear()).substring(2, 4) + "-";
        driverNumber += String.format("%03d", driverLicense.getBirthMonthDayGender()) + "-";
        driverNumber += driverLicense.getOverflow();

        return driverNumber;
    }
}
