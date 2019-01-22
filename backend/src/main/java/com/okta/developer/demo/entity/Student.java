package  com.okta.developer.demo.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="student")
public class Student {
    @Id
    @SequenceGenerator(name="student_seq",sequenceName="student_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
    @Column(name="STUDENT_ID",unique = true, nullable = true)
    private @NonNull Long Student_id;

    public Long getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(Long student_id) {
        Student_id = student_id;
    }

    private @NonNull String student_name;



    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
