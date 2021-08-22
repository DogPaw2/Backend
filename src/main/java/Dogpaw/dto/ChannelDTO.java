package Dogpaw.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class ChannelDTO {
    @Data
    public static class Create extends Update {

    }

    @Data
    public static class Update {
        private String name;
        private String purpose;
    }

    @Data
    public static class Delete {
        private Long id;
    }
}
