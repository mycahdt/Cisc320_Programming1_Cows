package chasePractice;


public class Cow {

	private int id;	
	private int lowestWeight = 0;
	private int latestWeight = 0;
	private int milk = 0;
	private int temp = 0;
	private int avgMilkProduction = 0;
	private int timestamp = 0;
	private int milkNum = 0;
	
	Cow(int id, String actionCode, int info, int timestamp){
		this.id = id;
		if(actionCode.equals("W")) {
			this.latestWeight = info;
			this.lowestWeight = info;
		} else if (actionCode.equals("M")) {
			this.milk = info;
			this.milkNum = 1;
			this.avgMilkProduction = this.milk / this.milkNum;
		} else if (actionCode.equals("T")) {
			this.temp = info;
		}
		this.timestamp = timestamp;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLowestWeight() {
		return lowestWeight;
	}

	public void setLowestWeight(int lowestWeight, int latestWeight) {
		if(lowestWeight == 0 || latestWeight < lowestWeight) {
			this.lowestWeight = latestWeight;
		} 
	}

	public int getLatestWeight() {
		return latestWeight;
	}

	public void setLatestWeight(int lastestWeight) {
		this.latestWeight = lastestWeight;
	}
	
	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk += milk;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getAvgMilkProduction() {
		return avgMilkProduction;
	}

	public void setAvgMilkProduction(int milk, int milkNum) {
		if(milk != 0 && milkNum != 0) {
			this.avgMilkProduction = milk/milkNum;
		}
	}
	
	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getMilkNum() {
		return milkNum;
	}

	public void setMilkNum(int milkNum) {
		this.milkNum = milkNum+1;
	}

}
