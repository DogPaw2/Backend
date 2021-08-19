package Dogpaw.dto;

import Dogpaw.domain.Chat;
import Dogpaw.domain.ChatMapping;
import Dogpaw.domain.Chatting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

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

    @Data
    @AllArgsConstructor
    public static class ChattingResponse{
        Boolean success;
        private List<ChatMapping> chats;
        private Chatting chatting;
    }

}
