package Dogpaw.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Channel {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String purpose;

    @OneToMany(mappedBy = "channel")
    private List<UserChannel> users = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "CHATTING_ID")
    private Chatting chatting;

}
