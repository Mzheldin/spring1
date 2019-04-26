package lesson1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("therapist")
public class Therapist implements Idoctor {

    @Value("Терапевт")
    private String name;

    @Override
    public void appointment() {
        System.out.println(name + " ведет прием пациента");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
