package Dogpaw.api;

import Dogpaw.domain.Chatting;
import Dogpaw.dto.ChattingDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.ChattingService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChattingApiController {
    @NonNull
    private final ChattingService chattingService;

    @PostMapping("/chatting")
    public ResponseDTO.Create createChatting (@RequestBody ChattingDTO.Create dto) throws ChattingService.ArgumentNullException, ChattingService.InvalidArgumentException{
        Chatting chatting = new Chatting(dto.getName(), dto.getPurpose());

        Long saveId = chattingService.saveChatting(chatting);

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/chatting")
    public ResponseDTO.Delete deleteChatting(@RequestBody ChattingDTO.Delete dto) throws NotFoundException{
        chattingService.deleteByChattingId(dto.getId());
        return new ResponseDTO.Delete(true);
    }

}
