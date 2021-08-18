package Dogpaw.dto.Workspace;

import lombok.Data;

@Data
public class ResponseDeletMessageDTO {
    private Boolean success;

    public ResponseDeletMessageDTO(Boolean success) { this.success = success; }
}
