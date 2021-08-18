package Dogpaw.service;

import Dogpaw.domain.Message;
import Dogpaw.repository.MessageRepository;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {

    @NonNull
    private final MessageRepository messageRepository;

    public Long saveMessage(Message message) throws ArgumentNullException, InvalidArgumentException {
        if(message == null) {
            throw new ArgumentNullException("Message can't be null");
        }
        if(message.getSendBy().isEmpty() || message.getText().isEmpty()){
            throw new InvalidArgumentException("Message SendBy or TEXT is null");
        }
        Message save = messageRepository.save(message);

        return save.getId();
    }

    public Message findOne(Long id) throws NotFoundException {
        Message message = messageRepository.findById(id).orElseThrow(() -> new MessageService.MessageNotFoundException("Message with id : " + id + "is not valid"));
        return message;
    }

    public void deleteByMessageId(Long id) throws NotFoundException {
        messageRepository.deleteById(id);
    }

    public static class MessageNotFoundException extends NotFoundException {
        public MessageNotFoundException(String msg) { super(msg); }
    }

    public static class ArgumentNullException extends Throwable {
        public ArgumentNullException(String s) {}
    }

    public static class InvalidArgumentException extends Throwable {
        public InvalidArgumentException(String s) {

        }
    }
}
