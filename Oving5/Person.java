package oving5;

import java.util.ArrayList;

public class Person {
	
	
	private String name;
	private char gender;
	private Person mom;
	private Person dad;
	private ArrayList<Person> children;
	
	public Person(String name, char gender){
		ArrayList<Person> children = new ArrayList<>();
		if (gender != 'F' && gender != 'M'){
			throw new IllegalArgumentException("Du må være mann eller kvinne");
		}
		this.children = children;
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	public Person getMother() {
		return mom;
	}

	public Person getFather() {
		return dad;
	}
	
	public int getChildCount(){
		return children.size();
	}
	
	public Person getChild(int n){
		if ((n > children.size()-1) || n<0){
			throw new IllegalArgumentException("Dette barnet finnes ikke");
		}
		return children.get(n);
	}
	
	public void addChild(Person child){
		if (this == child){
			throw new IllegalArgumentException("Du kan ikke være ditt eget barn");
		}
		if (this.children.contains(child)){
			throw new IllegalArgumentException("Du har allerede dette barnet");
		}
		this.children.add(child);
		if (this.gender == 'F'){
			if(child.mom != null){
				child.mom.removeChild(child);
			}
			child.mom = this;
			
		}
		else if (this.gender == 'M'){
			if(child.dad != null){
				child.dad.removeChild(child);
			}
			child.dad = this;
			
		}
	}
	
	public void removeChild(Person child){
		if (this == child){
			throw new IllegalArgumentException("Du kan ikke fjærne deg selv");
		}
		if (!this.children.contains(child)){
			throw new IllegalArgumentException("Du har ikke dette barnet!");
		}
		if (this.gender == 'F'){
			child.mom = null;
			this.children.remove(child);	
		}
		else if (this.gender == 'M'){
			child.dad = null;
			this.children.remove(child);
		}
	}
	
	public void setMother(Person mother){
		if (this == mother){
			throw new IllegalArgumentException("Du kan ikke være din egen mor");
		}
		if (mother.gender != 'F'){
			throw new IllegalArgumentException("Mor må være kvinne");
		}
		if (this.mom != null){
			this.mom.removeChild(this);
		}
		mother.children.add(this);
		this.mom = mother;
	}
	
	public void setFather(Person father){
		if (this == father){
			throw new IllegalArgumentException("Du kan ikke være din egen far");
		}
		if (father.gender != 'M'){
			throw new IllegalArgumentException("Far må være mann");
		}
		if (this.dad != null){
			this.dad.removeChild(this);
		}
		this.dad = father;
		father.children.add(this);
		
	}
	
	

}
