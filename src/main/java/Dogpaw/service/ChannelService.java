package Dogpaw.service;

import Dogpaw.domain.Channel;
import Dogpaw.repository.ChannelRepository;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChannelService {
    @NonNull
    private final ChannelRepository channelRepository;

    public Long saveChannel (Channel channel) throws ArgumentNullException, InvalidArgumentException {
        if(channel == null){
            throw new ArgumentNullException("Channel can't be null");
        }
        if(channel.getName().isEmpty() || channel.getPurpose().isEmpty()){
            throw new InvalidArgumentException("Channel Id or URl is null");
        }
        Channel save = channelRepository.save(channel);

        return save.getId();

    }

    public Channel findOne(Long id) throws NotFoundException {
        Channel channel = channelRepository.findById(id).orElseThrow(() -> new ChannelNotFoundException("Channel with id : " + id + "is not valid"));
        return channel;
    }


    public void deleteByChannelId(Long id) throws NotFoundException {
        channelRepository.deleteById(id);
    }



    public static class ChannelNotFoundException extends NotFoundException {
        public ChannelNotFoundException(String msg) {
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
