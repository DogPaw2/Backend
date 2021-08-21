package Dogpaw.api;

import Dogpaw.domain.MessageAll;
import Dogpaw.domain.MessageMapping;
import Dogpaw.dto.MessageAllDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.MessageAllService;
import Dogpaw.service.MessageService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MessageAllApiController {
    @NonNull
    private final MessageAllService messageAllService;
    private final MessageService messageService;

    @PostMapping("/messageall")
    public ResponseDTO.Create createMessageAll (@RequestBody MessageAllDTO.Create dto) throws MessageAllService.ArgumentNullException, MessageAllService.InvalidArgumentException{
        MessageAll messageAll = new MessageAll(dto.getUser());

        Long saveId = messageAllService.saveMessageAll(messageAll);

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/messageall")
    public ResponseDTO.Delete deleteMessageAll(@RequestBody MessageAllDTO.Delete dto) throws NotFoundException {
        messageService.deleteByMessageId(dto.getId());
        return new ResponseDTO.Delete(true);
    }

    @GetMapping("/messageall")
    public ResponseDTO.MessageAllResponse getMessageAll(@RequestBody MessageAllDTO.Get dto) throws NotFoundException {
        MessageAll messageAll = messageAllService.findOne(dto.getId());
        List<MessageMapping> messageList = messageService.getMessageList(dto.getId());
        return new ResponseDTO.MessageAllResponse(true, messageList, messageAll);
    }

}
