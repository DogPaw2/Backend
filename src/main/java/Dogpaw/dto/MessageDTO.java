package Dogpaw.dto;

import Dogpaw.domain.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class MessageDTO {

    @Data
    public static class Create extends Update {
        private Long messageId;
    }

    @Data
    public static class Update {
        private byte sendBy;
        private String text;
        private LocalDate date;
        private LocalTime time;
    }

    @Data
    public static class Delete {
        private Long id;
    }
}
