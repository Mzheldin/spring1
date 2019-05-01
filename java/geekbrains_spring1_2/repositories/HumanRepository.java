package geekbrains_spring1_2.repositories;

import geekbrains_spring1_2.entity.Human;
import org.springframework.stereotype.Component;

@Component
public class HumanRepository {

    public Human findHumanById(int id){
        Human human = new Human();
        human.setName("Human " + id);
        human.setAge(id);
        human.setCountry("country" + id);
        return human;
    }

}
