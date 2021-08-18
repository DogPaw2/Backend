package Dogpaw.api;


import Dogpaw.domain.Idea;
import Dogpaw.service.IdeaService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IdeaApiController {
    Date date = new Date();

    @NonNull
    private final IdeaService IdeaService;

    @PutMapping("/Idea")
    public ResponseDTO.Create createIdea(@RequestBody IdeaDTO.Create dto) throws IdeaService.ArgumentNullException, IdeaService.InvalidArgumentException {
        Idea Idea = new Idea(dto.getUser(), dto.getText(), dto.getContents(), date);

        Long saveId = IdeaService.saveIdea(Idea);

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/Idea")
    public ResponseDTO.Delete deleteIdea(@RequestBody IdeaDTO.Delete dto) throws NotFoundException {
        IdeaService.deleteByIdeaId(dto.getId());
        return new ResponseDTO.Delete(true);
    }
}
