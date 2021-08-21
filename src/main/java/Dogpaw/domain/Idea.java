package Dogpaw.domain;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Date date;

//    @OneToMany
//    List<File> files_ID = new ArrayList<>();

}