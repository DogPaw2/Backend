package Dogpaw.service;

import Dogpaw.domain.Message;
import Dogpaw.domain.MessageAll;
import Dogpaw.domain.MessageMapping;
import Dogpaw.repository.MessageAllRepository;
import Dogpaw.repository.MessageRepository;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {

    @NonNull
    private final MessageRepository messageRepository;
    private final MessageAllRepository messageAllRepository;

    public Long saveMessage(Message message) throws ArgumentNullException, InvalidArgumentException {
        if(message == null) {
            throw new ArgumentNullException("Message can't be null");
        }
        if(message.getText().isEmpty()){
            throw new InvalidArgumentException("Message TEXT is null");
        }
        Message save = messageRepository.save(message);

        return save.getId();
    }

    public Message findOne(Long id) throws NotFoundException {
        Message message = messageRepository.findById(id).orElseThrow(() -> new MessageNotFoundException("Message with id : " + id + "is not valid"));
        return message;
    }

    public void deleteByMessageId(Long id) throws NotFoundException {
        messageRepository.deleteById(id);
    }

    // ** 업데이트 추가 **
    public void updateByMessageId(Long id, String text) throws NotFoundException {
        Message message = findOne(id);
        message.setText(text);
        messageRepository.save(message);
    }

    public List<MessageMapping> getMessageList(Long id) throws NotFoundException {
        MessageAll messageAll = messageAllRepository.findById(id).orElseThrow(() -> new MessageAllService.MessageAllNotFoundException("MessageAll with id : "+ id + "is not valid"));
        return messageRepository.findAllMessage(messageAll);
    }


    // exception

    public static class MessageNotFoundException extends NotFoundException {
        public MessageNotFoundException(String msg) { super(msg); }
    }

    public static class ArgumentNullException extends Throwable {
        public ArgumentNullException(String s) {}
    }

    public static class InvalidArgumentException extends Throwable {
        public InvalidArgumentException(String s) {}
    }
}
