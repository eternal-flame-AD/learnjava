package csaFreeResponse;
import java.util.*;
public class TCook {
	public static void main(String[] args) {
		Ingredient ingredient1=new Ingredient("I1",0.5);
		Ingredient ingredient2=new Ingredient("I2",0.33);
		Recipe Recipe1=new Recipe("R1",1);
		Recipe1.addIngredient(ingredient1);
		Recipe1.addIngredient(ingredient2);
		ArrayList recipeList=new ArrayList();
		recipeList.add(Recipe1);
		Cookbook testcb=new Cookbook(recipeList);
		testcb.standardize(3);
		testcb.dumpRecipe();
	}
}
class Cookbook {
	private ArrayList recipeList;
	public Cookbook(ArrayList recipes) {
		recipeList=recipes;
	}
	public void standardize (int numPeople) {
		Iterator iter= recipeList.iterator();
		while (iter.hasNext()) {
			((Recipe)iter.next()).scaleByNum(numPeople);
		}
	}
	public void dumpRecipe() {
		Iterator iterrecipe=recipeList.iterator();
		while (iterrecipe.hasNext()) {
			Recipe currrecipe=(Recipe)iterrecipe.next();
			Iterator iteringredient=currrecipe.getIngredient().iterator();
			while (iteringredient.hasNext()) {
				System.out.println(((Ingredient)iteringredient.next()).getAmount());
			}
		}
	}
}

class Recipe {
	private String name;
	private int numServed;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private String desc;
	public Recipe(String name, int num) {
		this.name=name;
		numServed=num;
	}
	public ArrayList<Ingredient> getIngredient(){
		return ingredients;
	}
	public String getName() {
		return name;
	}
	public void addIngredient(Ingredient ing) {
		ingredients.add(ing);
	}
	public void setDesc(String des) {
		desc=des;
	}
	public String getDesc() {
		return desc;
	}
	public int getNumServed() {
		return numServed;
	}
	public void scaleByNum(int newnum) {
		double mult=(double)newnum/numServed;
		Iterator<Ingredient> iter=ingredients.iterator();
		while (iter.hasNext()) {
			Ingredient ing=iter.next();
			ing.setAmount(ing.getAmount()*mult);
			ing.setNumberServed(newnum);
		}
	}
}

class Ingredient {
	private String name;
	private double amount;
	public Ingredient(String name,double amount) {
		this.name=name;
		this.amount=amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amt) {
		amount=amt;
	}
	public void setNumberServed(int newNumber) {
		
	}
}