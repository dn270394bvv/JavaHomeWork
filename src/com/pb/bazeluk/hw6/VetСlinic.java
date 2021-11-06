package com.pb.bazeluk.hw6;

import java.lang.reflect.Constructor;
import java.nio.channels.UnresolvedAddressException;
import java.util.Locale;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
    Animal[] allAnimal = {new Cat("Рыба", new Locale("Котячий","Коробка"))
            ,new Dog("Кость",new Locale("Собачий","Будка"))
            ,new Horse("трава",new Locale("конячий","Cтойло"),"Дартаньян")};
Class veterinarianClazz = Class.forName("com.pb.bazeluk.hw6.Veterinarian");
        Constructor constrVeterinarian = veterinarianClazz.getConstructor(new Class[]{});
        Object objVeterinarian = constrVeterinarian.newInstance();
        if (objVeterinarian instanceof Veterinarian){
            ((Veterinarian) objVeterinarian).treatAnimal(allAnimal);
        }

    }
}
