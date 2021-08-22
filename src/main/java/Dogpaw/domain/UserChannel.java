package Dogpaw.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class UserChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    @NonNull
    private Channel channel;
}
