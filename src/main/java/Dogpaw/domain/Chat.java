package Dogpaw.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "USER_ID")
    @NonNull
    private Long user;

    @NonNull
    private String text;

    @NonNull
    private LocalDate date;
    @NonNull
    private LocalTime time;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHATTING_ID")
    private Chatting chatting;

}
