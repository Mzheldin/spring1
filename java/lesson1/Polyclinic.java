package lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Polyclinic {
    public static void main(String[] args) {
        ApplicationContext contextXml = new ClassPathXmlApplicationContext("config.xml");
        Patient patientXml = contextXml.getBean("patient", Patient.class);
        patientXml.appointment_with_doctor();

        ApplicationContext contextAppConf = new AnnotationConfigApplicationContext(AppConfig.class);
        Patient patientAppConf = contextAppConf.getBean("patient", Patient.class);
        patientAppConf.appointment_with_doctor();
    }
}
