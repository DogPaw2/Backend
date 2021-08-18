package Dogpaw.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Getter
@Setter
// why protected?
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//builds constructor with @NonNull annotation
@RequiredArgsConstructor
public class Idea {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String user;

    @NonNull
    private String text;

    @NonNull
    private String contents;

    @NonNull
    private Date date;

}