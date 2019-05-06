package geekbrains_spring1_2.controllers;

import geekbrains_spring1_2.entity.Human;
import geekbrains_spring1_2.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/human")
public class HumanController {

    private HumanService humanService;

    @Autowired
    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    @RequestMapping(path = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Human humanInfo(@RequestBody Human human){
        System.out.println(human.getName() + " " + human.getAge() + " " + human.getCountry());
        return human;
    }

    @RequestMapping(path = "/infoPage", method = RequestMethod.POST)
    public String humanInfoPage(Model uiModel, @RequestBody Human human){
        System.out.println(human.getName() + " " + human.getAge() + " " + human.getCountry());
        uiModel.addAttribute("human", human);
        return "humanInfo";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Human> getHumans(){
        for (Human human: humanService.getHumanList()) {
            System.out.println(human.getName() + " " + human.getAge() + " " + human.getCountry());
        }
        return humanService.getHumanList();
    }

}
