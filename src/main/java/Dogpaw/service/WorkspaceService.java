package Dogpaw.service;

import Dogpaw.domain.Workspace;
import Dogpaw.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public Boolean save (Workspace workspace){
        if(workspace.getName()=="" || workspace.getUrl()=="")
            return false;
        workspaceRepository.save(workspace);
        return true;
    }

    public Workspace findOne(Long id){
        Workspace workspace = workspaceRepository.findById(id);

        return workspace;
    }


    public void delete(Workspace workspace) {
        workspaceRepository.delete(workspace);
    }

}
