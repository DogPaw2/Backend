package Dogpaw.dto.Workspace;

import lombok.Data;

@Data
public class ResponseDeleteWorkspaceDTO {
    private Boolean success;

    public ResponseDeleteWorkspaceDTO(Boolean success) {
        this.success = success;
    }
}
