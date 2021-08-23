package Dogpaw.dto;

import Dogpaw.domain.Message;
import lombok.Data;

import java.util.List;

public class MessageRoomDTO {
    @Data
    public static class Create extends Update {

    }

    @Data
    public static class Update {
        private String user;

    }

    @Data
    public static class Delete {
        private Long id;
    }

    @Data
    public static class Get {
        private Long id;
    }

}
