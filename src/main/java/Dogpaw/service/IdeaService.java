package Dogpaw.service;

import Dogpaw.domain.Idea;
import Dogpaw.repository.IdeaRepository;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IdeaService {

    @NonNull
    private final IdeaRepository ideaRepository;

    public Long saveIdea (Idea idea) throws ArgumentNullException, InvalidArgumentException {
        //fail fast pattern
        //if Argument is invalid, dont do any logic
        if(idea == null){
            throw new ArgumentNullException("Idea can't be null");
        }
        if(idea.getText().isEmpty()){
            throw new InvalidArgumentException("Idea text is null");
        }
        Idea save = ideaRepository.save(idea);

        return save.getId();

    }

    public Idea findOne(Long id) throws NotFoundException {
        Idea idea = ideaRepository.findById(id).orElseThrow(() -> new IdeaNotFoundException("Idea with id : " + id + "is not valid"));
        return idea;
    }


    public void deleteByIdeaId(Long id) throws NotFoundException {

        ideaRepository.deleteById(id);

    }


    public static class IdeaNotFoundException extends NotFoundException {
        public IdeaNotFoundException(String msg) {
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
