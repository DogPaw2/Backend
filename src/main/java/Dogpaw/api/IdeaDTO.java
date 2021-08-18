package Dogpaw.api;

import lombok.Data;

public class IdeaDTO {

    @Data
    public static class Create extends Update{

    }

    @Data
    public static class Update {

        private String user;

        private String text;

        private String contents;

    }

    @Data
    public static class Delete {
        private Long id;
    }
}
