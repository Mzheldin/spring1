package lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("patient")
public class Patient {

    @Autowired
    @Qualifier("therapist")
    private Idoctor idoctor;

    public void appointment_with_doctor(){
        System.out.println("Пациент идет на прием к " + idoctor.getName());
        idoctor.appointment();
    }

    public Idoctor getIdoctor() {
        return idoctor;
    }

    public void setIdoctor(Idoctor idoctor) {
        this.idoctor = idoctor;
    }
}
