package bookreminder.bookreminder.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Report {

    @Id @GeneratedValue
    @Column(name = "report_id")
    private Long id;

    @OneToOne(mappedBy = "report", fetch = FetchType.LAZY)
    private Book book;

    private String summary;

    private String preview;

    private String review;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Memo> memos = new ArrayList<>();

}
