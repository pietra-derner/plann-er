package com.rocketseat.planner.trip;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record TripRequestPayload(String destination, String starts_at, String ends_at,
                                 List<String> emails_to_invite, String owner_email,
                                 String owner_name) {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public boolean isValidTrip() {
        LocalDate startDate = LocalDate.parse(starts_at, DATE_FORMATTER);
        LocalDate endDate = LocalDate.parse(ends_at, DATE_FORMATTER);
        return startDate.isBefore(endDate);
    }

    public void validate() {
        if (!isValidTrip()) {
            throw new IllegalArgumentException("A data de início deve ser anterior à data de término.");
        }
    }
}
