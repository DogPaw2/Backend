package Dogpaw.dto.Workspace;

import lombok.Data;

@Data
public class ResponseMakeWorkspaceDTO {
    private Long id;
    private Boolean success;

    public ResponseMakeWorkspaceDTO(Long id, Boolean success){
        if(success == true){
            this.id = id;
        }
        this.success = success;
    }
}
