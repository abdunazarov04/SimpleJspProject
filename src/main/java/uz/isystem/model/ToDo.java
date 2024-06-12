package uz.isystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ToDo{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String message;
    private String isDone;

    public ToDo(String message, String isDone, Users users) {
        this.message = message;
        this.isDone = isDone;
        this.users = users;
    }

    @ManyToOne
    private Users users;

    public ToDo(String message, String isDone) {
        this.message = message;
        this.isDone = isDone;
    }
}
