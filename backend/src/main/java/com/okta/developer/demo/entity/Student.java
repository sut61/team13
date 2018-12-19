package entity;
import javax.persistence.*;
import lombok.*;
public class Student {
    @Id
    private @NonNull
    long id;
    private @NonNull
    String username;
    private @NonNull
    String num;
    private @NonNull
    String nation;
    private @NonNull
    String disease;


    public Student(String username,
                   String num,
                   String disease


    ) {
        this.username = username;
        this.num = num;
        this.disease = disease;


    }
}
