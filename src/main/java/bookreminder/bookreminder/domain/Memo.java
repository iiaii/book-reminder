package bookreminder.bookreminder.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Memo {

    @Id @GeneratedValue
    @Column(name = "memo_id")
    private Long id;

    private String quote;

    private Long pages;

}
