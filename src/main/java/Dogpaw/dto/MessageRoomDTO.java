package Dogpaw.dto;

import Dogpaw.domain.Message;
import Dogpaw.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;


public class MessageRoomDTO {

    @Data
    public static class Create extends Update {

    }

    @Data
    public static class Update {
        private Long userId;

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
