package Dogpaw.api;

import Dogpaw.domain.IdeaMapping;
import Dogpaw.domain.IdeaBoard;
import Dogpaw.dto.IdeaBoardDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.IdeaService;
import Dogpaw.service.IdeaBoardService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IdeaBoardApiController {
    @NonNull
    private final IdeaBoardService IdeaBoardService;
    private final IdeaService IdeaService;

    @PostMapping("/IdeaBoard")
    public ResponseDTO.Create createIdeaBoard (@RequestBody IdeaBoardDTO.Create dto) throws IdeaBoardService.ArgumentNullException, IdeaBoardService.InvalidArgumentException{
        IdeaBoard IdeaBoard = new IdeaBoard(dto.getName(), dto.getPurpose());

        Long saveId = IdeaBoardService.saveIdeaBoard(IdeaBoard);

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/IdeaBoard")
    public ResponseDTO.Delete deleteIdeaBoard(@RequestBody IdeaBoardDTO.Delete dto) throws NotFoundException{
        IdeaBoardService.deleteByIdeaBoardId(dto.getId());
        return new ResponseDTO.Delete(true);
    }

    @GetMapping("/IdeaBoard")
    public ResponseDTO.IdeaBoardResponse getIdeaBoard(@RequestBody IdeaBoardDTO.Get dto) throws NotFoundException{
        IdeaBoard IdeaBoard = IdeaBoardService.findOne(dto.getId());
        List<IdeaMapping> IdeaList = IdeaService.getIdeaList(dto.getId());
        return new ResponseDTO.IdeaBoardResponse(true, IdeaList, IdeaBoard);

    }

}
