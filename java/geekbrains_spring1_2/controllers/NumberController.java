package geekbrains_spring1_2.controllers;

import geekbrains_spring1_2.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/number")
public class NumberController {

    private NumberService numberService;

    @Autowired
    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }

    @RequestMapping(path = "/sum", method = RequestMethod.GET)
    @ResponseBody
    public Integer getSum(@RequestParam int a, @RequestParam int b){
        return numberService.Sum(a, b);
    }

    @RequestMapping(path = "/sumPage", method = RequestMethod.GET)
    public String getSumPage(Model uiModel, @RequestParam int a, @RequestParam int b){
        uiModel.addAttribute("A", a);
        uiModel.addAttribute("B", b);
        uiModel.addAttribute("sum", numberService.Sum(a, b));
        return "numSum";
    }
}
