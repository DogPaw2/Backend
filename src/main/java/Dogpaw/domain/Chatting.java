package Dogpaw.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Chatting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String purpose;

//    @NonNull
//    private String user;

}
