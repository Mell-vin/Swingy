package com.lgumede.swingy.model.modelInterfaces;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lgumede.swingy.view.Panels;

public interface FightReady {
    public void upgradeHero (int villainAttack, JPanel panel, Panels viewPanel, EvilVills villain);
    public String getName();
    public int getLevel();
    public ImageIcon getHero();
    public void resetAttack(int num);
    public void resetDefense(int num);
    public void resetHitPoints(int num);
    public String getHeroClass();
    public void heroLimit(int level);
    public String getArtifactName();
    public void setAttack(int num);
    public int getAttack();
    public void setDefense(int num);
    public void setLevel(int num);
    public void setID(int num);
    public int getID();
    public int getHitPoints();
    public void setHitPoints(int num);
    public int getRow();
    public int getCol();
    public int getLimit();
    public void setArtifact(String artName, int num);
    public void setCol(int num);
    public void setRow(int num);
    public int getDefense();
    public int getExperience();
    public int getPrevRow();
    public int getPrevCol();
    public void setPrev(int prevRow, int prevCol);
    public void resetRowCol(int x, int y);
    public void borderReached(int xpGain, JLabel alert, JPanel panel);

}
