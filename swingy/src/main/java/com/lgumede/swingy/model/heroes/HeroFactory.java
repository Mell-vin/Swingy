package com.lgumede.swingy.model.heroes;

import com.lgumede.swingy.model.modelInterfaces.FightReady;

public abstract class HeroFactory {
    public FightReady newHero(String name, String heroClass) {

        if (name != null && heroClass != null) {
            if (name.equals("Lightning Rod")){
                return new LightningRod(name, heroClass);
            } else if (name.equals("Water Flush")){
                return new WaterFlush(name, heroClass);
            } else if (name.equals("Rock Roller")){
                return new RockRoller(name, heroClass);
            } else if (name.equals("Mud slide")){
                return new MudSlide(name, heroClass);
            } else if (name.equals("All power")){
                return new AllPower(name, heroClass);
            }
        }
        return null;
    }
}
