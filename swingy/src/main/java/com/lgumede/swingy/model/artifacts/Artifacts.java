package com.lgumede.swingy.model.artifacts;

import java.util.Random;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

import org.hibernate.event.spi.EvictEvent;

public class Artifacts {
    private String[] type = {"Weapon", "Armor", "Helm"};
    
    public void addArtifact(FightReady hero, EvilVills villain) {
        String villName = villain.getName();
        String name = this.type[ new Random().nextInt(3)];

        if (villName.equals("Bane")){
            hero.setArtifact(name, 25);
        } else if (villName.equals("Freiza Gold")){
            hero.setArtifact(name, 20);
        } else if (villName.equals("Hvitserk")){
            hero.setArtifact(name, 10);
        } else if (villName.equals("Ivar")){
            hero.setArtifact(name, 5);
        } else if (villName.equals("Thanosy")){
            hero.setArtifact(name, 15);
        }
        System.out.println("You won a " + hero.getArtifactName() + "\n");
    }
}
