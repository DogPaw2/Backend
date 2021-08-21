package Dogpaw.dto;

import Dogpaw.domain.User;
import lombok.Data;

public class MessageAllDTO {
    @Data
    public static class Create extends Update {

    }

    @Data
    public static class Update {
        private User user;
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
