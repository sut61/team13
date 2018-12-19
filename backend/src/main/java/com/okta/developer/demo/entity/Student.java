package th.sut.sa.demo.entity;

import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
// @Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Table(name="Student")
public class Student { private  @NonNull Long id;

    private @NonNull String username;

    private @NonNull Long num;
    private @NonNull String nation;

    private @NonNull String disease;
    private @NonNull String allergy;
    private @NonNull Date dates;
}
