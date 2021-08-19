package Dogpaw.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ChatMapping {
    Long getUser();
    String getText();
    LocalDate getDate();
    LocalTime getTime();
}
