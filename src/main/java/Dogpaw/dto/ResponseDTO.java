package Dogpaw.dto;

import Dogpaw.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class ResponseDTO {


    @AllArgsConstructor
    @Data
    public static class BaseResponse {

        Boolean success;
    }

    public static class Create extends BaseResponse {
        Long id;

        public Create(Long id, Boolean success){
            super(success);
            this.id = id;
        }
    }

    // ** 업데이트 추가 **
    public static class Update extends BaseResponse {
        public Update(Boolean success) { super(success); }
    }

    public static class Delete extends BaseResponse {
        public Delete(Boolean success) {
            super(success);
        }
    }


    @Data
    @AllArgsConstructor
    public static class ChattingResponse {
        Boolean success;
        private List<ChatMapping> chats;
        private Chatting chatting;
    }

    @Data
    @AllArgsConstructor
    public static class MessageRoomResponse {
        Boolean success;
        private List<MessageMapping> messages;
        private MessageRoom messageRoom;
    }

}