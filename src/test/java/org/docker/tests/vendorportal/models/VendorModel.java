package org.docker.tests.vendorportal.models;

public record VendorModel(String username,
                          String password,
                          String monthlyEarning,
                          String annualEarning,
                          String profitMargin,
                          String availableInventory,
                          String searchKeyword,
                          int searchResultsCount) {
}
