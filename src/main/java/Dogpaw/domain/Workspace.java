package Dogpaw.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table
@Getter
@Setter
public class Workspace {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORKSPACE_ID")
    private Long id;

    private String name;

    private String url;

//    채널(채팅+아이디어), 메시지와 1:N 메핑.

    protected Workspace() { }

    public Workspace(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
