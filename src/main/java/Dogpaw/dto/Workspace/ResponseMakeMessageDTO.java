package Dogpaw.dto.Workspace;

import lombok.Data;

@Data
public class ResponseMakeMessageDTO {
    private Long id;
    private Boolean success;

    public ResponseMakeMessageDTO(Long id, Boolean success) {
        if(success) {
            this.id = id;
        }
        this.success = success;
    }
}
