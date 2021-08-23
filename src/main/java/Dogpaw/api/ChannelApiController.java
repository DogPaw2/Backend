package Dogpaw.api;

import Dogpaw.domain.*;
import Dogpaw.dto.ChannelDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.ChannelService;
import Dogpaw.service.ChattingService;
import Dogpaw.service.UserService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChannelApiController {
    @NonNull
    private final ChannelService channelService;
    @NonNull
    private final UserService userService;
    @NonNull
    private final ChattingService chattingService;

    @PostMapping("/channel")
    public ResponseDTO.Create createUser(@RequestBody ChannelDTO.Create dto) throws ChannelService.InvalidArgumentException, ChannelService.ArgumentNullException, ChattingService.InvalidArgumentException, ChattingService.ArgumentNullException, UserService.UserNotFoundException {
        Chatting chatting = new Chatting();
        Long saveId2 = chattingService.saveChatting(chatting);

        Channel channel = new Channel(dto.getName(), dto.getPurpose(),chatting);

        Long saveId = channelService.saveChannel(channel, dto.getUserId());

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/channel")
    public ResponseDTO.Delete createChat(@RequestBody ChannelDTO.Delete dto) throws NotFoundException {
        channelService.deleteByChannelId(dto.getId());
        chattingService.deleteByChattingId(dto.getId());

        return new ResponseDTO.Delete(true);
    }

    @GetMapping("/channel")
    public ResponseDTO.ChannelResponse getChatting(@RequestBody ChannelDTO.Get dto) throws NotFoundException{
        User user = userService.findOne(dto.getUserId());
        List<UserChannelMapping> channelList = channelService.getChannelList(dto.getUserId());
        return new ResponseDTO.ChannelResponse(true, channelList);

    }
}
