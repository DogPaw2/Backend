package Dogpaw.repository;

import Dogpaw.domain.Message;
import Dogpaw.domain.MessageAll;
import Dogpaw.domain.MessageMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
//    List<MessageMapping> findAllByMessageAll(MessageAll messageAll);
}
