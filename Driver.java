package project_one_Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

	public static ArrayList<Relation> relations = new ArrayList<>();
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		int index = 0, pick = 0;
		char check = ' ';
		 /**
		  * when the condition reach 
		  * updateTuple(1);
		     printRelation()
		  */
		do {
			System.out.println("Enter 1 to Add new relation.");
			System.out.println("Enter 2 to Update relation.");
			System.out.println("Enter 3 to view  Relations.");
			System.out.println("Your Input.");		
			pick = Integer.parseInt(input.nextLine());
			switch (pick) {
			
			case 1: {
				System.out.println("Enter name of your relation  : ");
				String name = input.nextLine();
				System.out.println("\n\t\tRelation '" + name + "'");
				ArrayList<Attribute> tAttrs = getTestAttributes();
				ArrayList<Tuple> testTuples = new Relation(name, tAttrs).insertTuple();
				relations.add(new Relation(name, tAttrs, testTuples));
				break;
			}
			case 2:
			{
				System.out.println("Enter name of your relation : ");
				String name = input.nextLine();
				int id = getIdByName(name);
				relations.get(id).printRelation();
				
				System.out.println("Enter 1 to Add new relation.");
				System.out.println("Enter 2 to Update relation.");
				System.out.println("Enter 3 to view  Relations.");
				System.out.println("Your Input.");	
				int choicCase2=Integer.parseInt(input.nextLine());
				switch(choicCase2){
					case 1:{
						relations.get(id).insertTuple();
						break;
					}
					case 2:{
						System.out.println("add Id ");
						int ids=Integer.parseInt(input.nextLine());
						relations.get(id).updateTuple(ids);
						break;
					}
					case 3:{
						System.out.print("add Id   ");
						int ids=Integer.parseInt(input.nextLine());
						relations.get(id).deleteTuple(ids);
						break;
					}
					case 0:{
						break;
					}}
				break;
			}
			case 3:{
				for (Relation relation : relations) {
					relation.printRelation();
		
				}
				break;
			}
		}
			System.out.println("enter N to stop, Y to to continue ");
			check = input.nextLine().charAt(0);
			index++;
		} while (check == 'n' || check == 'y');

		 relations.get(0).updateTuple(1);
		 relations.get(0).printRelation();

	}

	public static int getIdByName(String name) {
		int index = -1;
		for (int i = 0; i < relations.size(); i++) {
			if (name.matches(relations.get(i).getName())) {
				index = i;
			}
		}
		return index;

	}

	public static ArrayList<Attribute> getTestAttributes() {
		Scanner input = new Scanner(System.in);
		ArrayList<Attribute> attrs = new ArrayList<Attribute>();
		attrs.add( new Attribute("ORD_NUM", Integer.class) );
		attrs.add( new Attribute("ORD_AMOUNT", Integer.class) );
		attrs.add( new Attribute("ADVANCE_AMOUNT", Integer.class) );
		attrs.add( new Attribute("ORD_DATE", String.class) );
		attrs.add( new Attribute("CUST_CODE", String.class) );
		attrs.add( new Attribute("AGENT_CODE", String.class) );
		char check = ' ';
		
		// this adds more attribute
		do {
			System.out.print("\nEnter Attribute's Name : ");
			String name = input.nextLine();
			System.out.print("\nEnter Attribute's Type : ");
			String type = input.nextLine();
			
			System.out.println("enter N to stop, Y to to continue ");
			check = input.nextLine().charAt(0);
		} while (check == 'n' || check == 'y');

		return attrs;
	}

	public static ArrayList<Tuple> getTestTuples(ArrayList<Attribute> attrs) {
		
		ArrayList<Tuple> tuples = new ArrayList<Tuple>();	
		Scanner input = new Scanner(System.in);
		char choice = ' ';
		
		do {
		HashMap<String, Object> attrValues = new HashMap<String, Object>();
		attrValues.put("ORD_NUM", Integer.valueOf(200137));
		attrValues.put("ORD_AMOUNT", Integer.valueOf(2000));
		attrValues.put("ADVANCE_AMOUNT", Integer.valueOf(800));
		attrValues.put("ORD_DATE", "09/16/2008");
		attrValues.put("CUST_CODE", "C00007");
		attrValues.put("AGENT_CODE", "A110");
		
		// this Insert Tuple
		System.out.println("Insert Tuple : ");
		String tuple = input.nextLine();
		String[] values = tuple.split(",");
		for (String string : values) {
		System.out.println(string);
		}
		for(int i=0;i<attrs.size();i++){
		attrValues.put(attrs.get(i).getName(), values[i]);
		}
		tuples.add(new Tuple(attrValues));
		System.out.println("enter N to stop, Y to to continue ");
		choice = input.nextLine().charAt(0);
		} while (choice == 'n' || choice == 'y');
		return tuples;
 
	
	}

  

}
