package com.weborders.utilites;

import org.testng.annotations.DataProvider;

public class DataProviderCollectionE {

    @DataProvider (name= "carModelsWithYears")
    public static Object[][] getRandomCarModelsWithYearsData(){
        Object[][] localObj = CSVReader.readFromCSV("CarModelsWithYears.csv");
        int rand = randNumber(0, localObj.length);

        return new Object[][]{
                {localObj[rand][0], localObj[rand][1]}
        };
    }

    private static int randNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
