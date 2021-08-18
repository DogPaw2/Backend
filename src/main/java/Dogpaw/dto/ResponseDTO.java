package Dogpaw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDTO {

    @Data
    @AllArgsConstructor
    public static class BaseResponse {

        Boolean success;
    }

    public static class Create extends BaseResponse{
        Long id;

        public Create(Long id, Boolean success){
            super(success);
            this.id = id;
        }
    }
    public static class Delete extends BaseResponse{
        public Delete(Boolean success) {
            super(success);
        }
    }

}
