package Dogpaw.api;

import Dogpaw.domain.Message;
import Dogpaw.domain.MessageAll;
import Dogpaw.domain.User;
import Dogpaw.dto.MessageDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.MessageAllService;
import Dogpaw.service.MessageService;
import Dogpaw.service.UserService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MessageApiController {

    @NonNull
    private final MessageService messageService;
    private final MessageAllService messageAllService;
    private final UserService userService;

    @PutMapping("/message")
    public ResponseDTO.Create createMessage(@RequestBody MessageDTO.Create dto) throws MessageService.ArgumentNullException, MessageService.InvalidArgumentException, NotFoundException {
        MessageAll messageAll = messageAllService.findOne(dto.getId());

        Message message = new Message(dto.getSendBy(), dto.getText(), dto.getDate(), dto.getTime(), messageAll);

        Long saveId = messageService.saveMessage(message);

        return new ResponseDTO.Create(saveId, true);
    }

    // ** 업데이트 추가 **
    @PutMapping("/message")
    public ResponseDTO.Update updateMessage(@RequestBody MessageDTO.Update dto, String text) throws NotFoundException {
        messageService.updateByMessageId(dto.getId(), dto.getText());
        return new ResponseDTO.Update(true);
    }

    @DeleteMapping("/message")
    public ResponseDTO.Delete deleteMessage(@RequestBody MessageDTO.Delete dto) throws NotFoundException {
        messageService.deleteByMessageId(dto.getId());
        return new ResponseDTO.Delete(true);
    }
}
