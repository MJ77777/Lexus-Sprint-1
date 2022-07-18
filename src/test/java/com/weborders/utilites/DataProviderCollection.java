package com.weborders.utilites;

import org.testng.annotations.DataProvider;

public class DataProviderCollection {

    @DataProvider (name= "carModelsWithYears")
    public static Object[][] getRandomCarModelsWithYearsData(){
        Object[][] localObj = CSVReader.readFromCSV("CarModelsWithYears.csv");
        int rand = randNumber(0, localObj.length);

        return new Object[][]{
                {localObj[rand][0], localObj[rand][1]}
        };
    }

    @DataProvider (name= "getRaceDriversWithNumbersData", parallel = true)
    public static Object[][] getRaceDriversWithNumbersData(){
        return CSVReader.readFromCSV("LexusRaceDrivers.csv");
    }

    private static int randNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
