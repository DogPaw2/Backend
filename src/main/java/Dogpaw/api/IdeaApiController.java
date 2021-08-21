package Dogpaw.api;


import Dogpaw.domain.File;
import Dogpaw.domain.Idea;
import Dogpaw.dto.IdeaDTO;
import Dogpaw.dto.ResponseDTO;
import Dogpaw.service.FileService;
import Dogpaw.service.IdeaService;
import javassist.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IdeaApiController {

    @NonNull
    private final IdeaService IdeaService;
    private final FileService FileService;

    @PostMapping("/Idea")
    public ResponseDTO.Create createIdea(@RequestBody IdeaDTO.Create dto, @RequestParam MultipartFile[] uploadFiles) throws IdeaService.ArgumentNullException, IdeaService.InvalidArgumentException {
        List<File> files = new ArrayList<>();
        for(MultipartFile file : uploadFiles){
            if(!file.isEmpty()){
                String fileName = file.getOriginalFilename();
                String contentType = file.getContentType();
                String savePath = System.getProperty("user.dir") + "\\files";
                if (!new File(savePath).exists()) {
                    try{
                        new File(savePath).mkdir();
                    }
                    catch(Exception e){
                        e.getStackTrace();
                    }
                }

                String filePath = savePath + "\\" + fileName;
            }
        }

        Idea Idea = new Idea(dto.getUser(), dto.getText(), dto.getDate());

        Long saveId = IdeaService.saveIdea(Idea);

        return new ResponseDTO.Create(saveId, true);
    }

    @DeleteMapping("/Idea")
    public ResponseDTO.Delete deleteIdea(@RequestBody IdeaDTO.Delete dto) throws NotFoundException {
        IdeaService.deleteByIdeaId(dto.getId());
        return new ResponseDTO.Delete(true);
    }
}
