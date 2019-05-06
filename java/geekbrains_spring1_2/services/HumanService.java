package geekbrains_spring1_2.services;

import geekbrains_spring1_2.entity.Human;
import geekbrains_spring1_2.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanService {

    private HumanRepository humanRepository;

    @Autowired
    public void setHumanRepository(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public Human getHumanById(int id){
        return humanRepository.findHumanById(id);
    }

    public List<Human> getHumanList(){
        List<Human> humanList = new ArrayList<>();
        for (int i = 0; i < 5; i++) humanList.add(humanRepository.findHumanById(i));
        return humanList;
    }
}
