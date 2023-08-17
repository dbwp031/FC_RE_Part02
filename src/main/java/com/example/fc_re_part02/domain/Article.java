package com.example.fc_re_part02.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/*
 * @JoinColumn(name, referencedColumnName)
 * name: 내(이 파일에선 Article) 테이블의 FK 필드 명
 * referencedColumnName: 조인할 컬럼명 (UserAccount 엔티티의 userId)
 *
 * ToString
 * 각 필드를 찍어서 보여준다.
 * 그런데 양방향 매핑해버리면 순환참조가 나버리기 때문에, Exclude를 사용하여 순환을 끊는다.
 *
 * @OrderBy
 * 엔티티 클래스의 컬렉션 타입 필드에 대한 정렬 방식
 * */
@Getter
@ToString(callSuper = true)
@Entity
public class Article extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    @Column(nullable = false, length = 10000)
    private String content;
    @Setter
    private String hashtag;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private UserAccount userAccount;

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected Article() {
    }

    private Article(UserAccount userAccount, String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.userAccount = userAccount;
    }

    public static Article of(UserAccount userAccount, String title, String content, String hashtag) {
        return new Article(userAccount, title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
