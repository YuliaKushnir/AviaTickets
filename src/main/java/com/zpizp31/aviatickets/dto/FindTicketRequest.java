package com.zpizp31.aviatickets.dto;

import java.time.LocalDate;

public class FindTicketRequest {
    private String fromCity;
    private String destinationCity;

    private LocalDate departDate;
    private LocalDate returnDate;



    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

    public void setDepartDate(LocalDate departDate) {
        this.departDate = departDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
