package Dogpaw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class ResponseDTO {


    @AllArgsConstructor
    @Data
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
