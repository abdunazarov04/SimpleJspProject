package uz.isystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String gender;

    public Users(String name, String username, String password, String gender, List<ToDo> toDo) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.toDo = toDo;
    }

    @OneToMany
    private List<ToDo> toDo;

    public Users(String name, String username, String password, String gender) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
}
