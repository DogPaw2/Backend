package Dogpaw.service;


import Dogpaw.domain.Chat;
import Dogpaw.repository.ChatRepository;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {
    @NonNull
    private final ChatRepository chatRepository;

    public Long saveChat (Chat chat) throws ArgumentNullException, InvalidArgumentException {
        if(chat == null){
            throw new ArgumentNullException("Chat can't be null");
        }
        if(chat.getText().isEmpty()){
            throw new InvalidArgumentException("Chatting text is null");
        }
        Chat save = chatRepository.save(chat);

        return save.getId();
    }

    public void deleteByChatId(Long id) throws NotFoundException{
        chatRepository.deleteById(id);
    }

    public Chat findOne(Long id) throws NotFoundException{
        Chat chat = chatRepository.findById(id).orElseThrow(() -> new ChatNotFoundException("Work space with id : " + id + "is not valid"));
        return chat;
    }


    // exception

    public static class ChatNotFoundException extends NotFoundException {
        public ChatNotFoundException(String msg) {
            super(msg);
        }
    }

    public static class ArgumentNullException extends Throwable {
        public ArgumentNullException(String s) {
        }
    }

    public static class InvalidArgumentException extends Throwable {
        public InvalidArgumentException(String s) {
        }
    }
}


