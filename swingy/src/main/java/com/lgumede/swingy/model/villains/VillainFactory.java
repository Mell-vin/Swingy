package com.lgumede.swingy.model.villains;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

import org.hibernate.dialect.FirebirdDialect;

import jdk.nashorn.internal.ir.ReturnNode;

public abstract class VillainFactory {
    public EvilVills newVillain(int i, int level) {
        if (level == 0) {
            if (i % 2 == 0){
                return new Ivar();
            } else if (i % 2 == 1){
                return new Hvitserk();
            }
        } else if (level == 1) {
            if (i % 2 == 0){
                return new Hvitserk();
            } else if (i % 2 == 1){
                return new Thanos();
            }
        } else if (level == 2) {
            if (i % 2 == 0){
                return new Thanos();
            } else if (i % 2 == 1){
                return new FreizaGold();
            }
        } else if (level == 3) {
            if (i % 2 == 0){
                return new FreizaGold();
            } else if (i % 2 == 1){
                return new Bane();
            }
        } else if (level == 4) {
            if (i == 0) {
                return new FreizaGold();
            }else if (i % 2 == 0){
                return new Bane();
            } else if (i % 2 == 1){
                return new Thanos();
            }
        } else if (level == 5) {
            if (i % 2 == 0){
                return new Bane();
            } else if (i % 2 == 1){
                return new Bane();
            }
        }
        return null;
    }
}
