package lesson1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lesson1")
public class AppConfig {

    @Bean(name = "therapist")
    public Idoctor therapist(){
        Therapist therapist = new Therapist();
        therapist.setName("Терапевт");
        return therapist;
    }

    @Bean(name = "neurologist")
    public Idoctor neurologist(){
        Neurologist neurologist = new Neurologist();
        neurologist.setName("Невролог");
        return neurologist;
    }

    @Bean(name = "patient")
    public Patient patient(Idoctor neurologist){
        Patient patient = new Patient();
        patient.setIdoctor(neurologist);
        return patient;
    }
}
