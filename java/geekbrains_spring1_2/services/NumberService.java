package geekbrains_spring1_2.services;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    public int Sum(int a, int b){
        return a + b;
    }

}
