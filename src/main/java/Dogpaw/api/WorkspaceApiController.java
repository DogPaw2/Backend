package Dogpaw.api;


import Dogpaw.domain.Workspace;
import Dogpaw.dto.Workspace.DeleteWorkspceDTO;
import Dogpaw.dto.Workspace.MakeWorkspaceDTO;
import Dogpaw.dto.Workspace.ResponseDeleteWorkspaceDTO;
import Dogpaw.dto.Workspace.ResponseMakeWorkspaceDTO;
import Dogpaw.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WorkspaceApiController {
    private final WorkspaceService workspaceService;

    @PutMapping("/make/workspace")
    public ResponseMakeWorkspaceDTO makeWorkspace(@RequestBody MakeWorkspaceDTO dto){
        Workspace workspace = new Workspace(dto.getName(), dto.getUrl());
        workspaceService.save(workspace);
        return new ResponseMakeWorkspaceDTO(workspace.getId(), true);
    }

    @DeleteMapping("/delete/workspace")
    public ResponseDeleteWorkspaceDTO makeWorkspace(@RequestBody DeleteWorkspceDTO dto){
        Workspace workspace = workspaceService.findOne(dto.getId());
        workspaceService.delete(workspace);
        return new ResponseDeleteWorkspaceDTO(true);
    }
}
