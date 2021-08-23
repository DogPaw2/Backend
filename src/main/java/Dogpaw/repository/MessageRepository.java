package Dogpaw.repository;

import Dogpaw.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<MessageMapping> findAllByMessageRoom(MessageRoom messageRoom);
}
