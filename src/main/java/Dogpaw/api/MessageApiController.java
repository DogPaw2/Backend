package Dogpaw.api;

import Dogpaw.domain.Message;
import Dogpaw.dto.MessageDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.MessageService;
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

    @PutMapping("/message")
    public ResponseDTO.Create createMessage(@RequestBody MessageDTO.Create dto) throws MessageService.ArgumentNullException, MessageService.InvalidArgumentException {
        Message message = new Message(dto.getSendBy(), dto.getText());

        Long saveId = messageService.saveMessage(message);

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/message")
    public ResponseDTO.Delete deleteMessage(@RequestBody MessageDTO.Delete dto) throws NotFoundException {
        messageService.deleteByMessageId(dto.getId());
        return new ResponseDTO.Delete(true);
    }
}
