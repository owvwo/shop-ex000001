package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.FrontApplication;

@Entity
@Table(name = "Menu_table")
@Data
//<<< DDD / Aggregate Root
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static MenuRepository repository() {
        MenuRepository menuRepository = FrontApplication.applicationContext.getBean(
            MenuRepository.class
        );
        return menuRepository;
    }
}
//>>> DDD / Aggregate Root
