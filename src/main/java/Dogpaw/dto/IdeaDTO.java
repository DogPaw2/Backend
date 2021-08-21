package Dogpaw.dto;

import Dogpaw.domain.File;
import lombok.Data;

import java.util.Date;
import java.util.List;

public class IdeaDTO {

    @Data
    public static class Create extends Update{

    }

    @Data
    public static class Update {

        private String user;

        private String text;

        private Date date;

        List<File> files;
    }

    @Data
    public static class Delete {
        private Long id;
    }
}
