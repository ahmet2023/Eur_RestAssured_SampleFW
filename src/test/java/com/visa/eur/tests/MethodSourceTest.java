package com.visa.eur.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class MethodSourceTest {

    public static List<String> getCountries() {
        List<String> countries = Arrays.asList("Canada","USA","France","Turkey","Mexico"
                ,"India","Germany");

        return countries;
    }

    @ParameterizedTest
    @MethodSource("getCountries")
    public void countriesTest(String countryName) {
        System.out.println("countryName = " + countryName);
        System.out.println(countryName.length());
    }

}
