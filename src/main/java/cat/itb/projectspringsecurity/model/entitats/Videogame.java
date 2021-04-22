package cat.itb.projectspringsecurity.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Videogame {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String genre;
    private String platform;
    private int score;
    private String shortDescription;

    public Videogame(String title, String genre, String platform, int score, String shortDescription) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.score = score;
        this.shortDescription = shortDescription;
    }
}
