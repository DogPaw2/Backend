package Dogpaw.service;

import Dogpaw.domain.MessageAll;
import Dogpaw.repository.MessageAllRepository;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageAllService {
    @NonNull
    private final MessageAllRepository messageAllRepository;

    public Long saveMessageAll(MessageAll messageAll) throws ArgumentNullException, InvalidArgumentException {
        if (messageAll == null) {
            throw new ArgumentNullException("MessageAll can't be null");
        }
        MessageAll save = messageAllRepository.save(messageAll);

        return save.getId();
    }

    public void deleteByMessageAllId(Long id) throws NotFoundException {
        messageAllRepository.deleteById(id);
    }

    public MessageAll findOne(Long id) throws NotFoundException {
        MessageAll messageAll = messageAllRepository.findById(id).orElseThrow(() -> new MessageAllNotFoundException("MessageAll with id : " + id + "is not valid"));
        return messageAll;
    }

    // exception

    public static class MessageAllNotFoundException extends NotFoundException {
        public MessageAllNotFoundException(String msg) {
            super(msg);
        }
    }

    public static class ArgumentNullException extends Throwable {
        public ArgumentNullException(String s) {}
    }

    public static class InvalidArgumentException extends Throwable {
        public InvalidArgumentException(String s) {}
    }

}
