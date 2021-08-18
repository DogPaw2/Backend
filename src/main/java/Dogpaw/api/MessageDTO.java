package Dogpaw.api;

import lombok.Data;

public class MessageDTO {

    @Data
    public static class Create extends Update {

    }

    @Data
    public static class Update {

        private String sendBy;

        private String text;

    }

    @Data
    public static class Delete {
        private Long id;
    }
}
