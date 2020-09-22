package com.lgumede.swingy.model.heroes;

public abstract class Heroes {
	private String name = "";
	private int level = 0;
	private String heroClass = "";
	private int row;
	private int col;
	private int limit;
	int ID;
	private int prevRow;
	private int prevCol;
	//artifact;
	
	public Heroes (String name, String heroClass) {
		this.heroLimit(this.level);
		this.setCol((int) Math.ceil(this.limit / 2));
		this.setRow((int) Math.ceil(this.limit / 2));
		this.setPrev((int) Math.ceil(this.limit / 2), (int) Math.ceil(this.limit / 2));
		this.name = name;
		this.heroClass = heroClass;
	}

	public String getName() {
		return this.name;
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
