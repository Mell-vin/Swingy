package com.lgumede.swingy.model.heroes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lgumede.swingy.model.modelInterfaces.FightReady;

public abstract class Heroes {

	@NotEmpty(message = "Name cannot be null")
	private String name;
	private int level = 0;

	@NotEmpty(message = "Name cannot be null")
	private String heroClass;
	private int row;
	private int col;
	private int limit;
	int ID;
	private int prevRow;
	private int prevCol;
	static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	// artifact;

	public Heroes(@NotEmpty String Hname, @NotEmpty String HheroClass) {
		this.heroLimit(this.level);
		this.setCol((int) Math.ceil(this.limit / 2));
		this.setRow((int) Math.ceil(this.limit / 2));
		this.setPrev((int) Math.ceil(this.limit / 2), (int) Math.ceil(this.limit / 2));
		this.name = Hname;
		this.heroClass = HheroClass;
	}

	public String getName() {
		return this.name;
	}

	public static int validatorr(FightReady hero) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<FightReady>> violations = validator.validate(hero);
		if (violations.size() > 0) {
			for (ConstraintViolation<FightReady> violation : violations) {
				System.out.println(violation.getMessage()); 
			}
			return 0;
		}
		return 1;
	}

	public void setRow(int row) {
		this.row += row;
	}

	public void setCol(int col) {
		this.col += col;
	}

	public void setID(int num) {
		this.ID = num;
	} 

	public int getID(){
		return this.ID;
	}
	public int getRow() {
		return this.row;
	}

	public void resetRowCol(int x, int y) {
		this.col = y;
		this.row = x;
	}

	public int getCol() {
		return this.col;
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void heroLimit(int level) {
		int part1 = (level - 1) * 5;
        int part2 = 10 - (level % 2);
		int dims = part1 + part2;
		this.limit = dims;
	}

	public void setPrev(int prevRow,int prevCol) {
		this.prevRow = prevRow;
		this.prevCol = prevCol;
	}

	public int getPrevRow() {
		return this.prevRow;
	}

	public int getPrevCol() {
		return this.prevCol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getHeroClass() {
		return this.heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
}
