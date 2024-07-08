package org.docker.tests.flightreservation.models;

public record PassengerModel(String firstName,
                                        String lastName,
                                        String email,
                                        String password,
                                        String street,
                                        String city,
                                        String zip,
                                        String passengersCount,
                                        String expectedPrice) {
}