package com.pb.bazeluk.hw6;

import java.util.Arrays;

public class Veterinarian {
    void treatAnimal(Animal... animals) {

        for (Animal animal : animals) {
            String[] classInfoArr = animal.getClass().getName().split("[.]");
            System.out.println("Животное " + classInfoArr[classInfoArr.length - 1] + ", употребляющее в еду " + animal.getFood() + ", пришло на лечение с " + animal.getLocation().getDisplayCountry());
        }
    }
}
