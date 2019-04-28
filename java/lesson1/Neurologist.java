package lesson1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("neurologist")
public class Neurologist implements Idoctor {

    @Value("Невролог")
    private String name;

    @Override
    public void appointment() {
        System.out.println(name + " ведет прием пациента");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
