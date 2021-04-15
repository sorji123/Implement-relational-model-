package project_one_Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


public class Relation {
	private String name;
	private ArrayList<Tuple> tuples;
	private ArrayList<Attribute> attributes;

	public Relation(String name, Collection<Attribute> attrs) {

		this.name = name;
		this.attributes = new ArrayList<Attribute>(attrs);
		this.tuples = new ArrayList<Tuple>();
	}

	public Relation(String name, Collection<Attribute> attrs, Collection<Tuple> tuples) {

		this.name = name;
		this.attributes = new ArrayList<Attribute>(attrs);
		this.tuples = new ArrayList<>(tuples);
 
	}
	  class agent {
    	  Long AGENT_CODE;
    	  String AGENT_NAME;
    	  String WORKING_AREA;
    	  int COMMISSION_PER;
    	  double PHONE_NO;
    	//  @AGENT_CODE
    	//  @GeneratedValue
    	//  private long AGENT_CODE; //(PK)

    	}
    	 
    	class customer {
    	  String CUST_COUNTRY;
    	  String CUST_CODE;
    	  String CUST_NAME;
    	  String CUST_CITY;
    	  int GRADE;
    	  int  BALANCE;
    	//  @CUST_CODE
    	//  @GeneratedValue
    	//  private long CUST_CODE; //(PK)

    	}
    	
    	class order{
    		int ORD_NUM ;
    		int ORD_AMOUNT;
    		int ADVANCE_AMOUNT;
    		String ORD_DATE;
    		String CUST_CODE;
    		String AGENT_CODE ;
    	//	 @ORD_NUM
	    	//  @GeneratedValue
	    	//  private long ORD_NUM; //(PK)

    	}
    

	public String getName() {
		return this.name; 
	}
	
	public ArrayList<Tuple> insertTuple() {
		Scanner input = new Scanner(System.in);
		 ArrayList<Tuple> tuples = new ArrayList<Tuple>();
		char choice = ' ';
		do {
			HashMap<String, Object> attrValues = new HashMap<String, Object>();
			System.out.print("\nInsert Tuple : ");
			String tuple = input.nextLine();
			String[] values = tuple.split(",");
			for (String string : values) {
				System.out.println(string);
			}
			for (int i = 0; i < this.attributes.size(); i++) {
				attrValues.put(this.attributes.get(i).getName(), values[i]);
			}

			if (this.tuples.isEmpty()) {
				this.tuples.add(new Tuple(attrValues));
			} else if (this.tuples.size() > 0) {
	//Check tuple duplicates
				
				Tuple temp = new Tuple(attrValues);
				int checkit=0;
				for (int i = 0; i < this.tuples.size(); i++) {
					if (temp.getTupleValues().equals(tuples.get(i).getTupleValues())) {
						System.out.println("theres a duplicate " + tuples.get(i).getTupleValues());
						break;

					}
					checkit++;
				}
				if(checkit==this.tuples.size()){
					this.tuples.add(new Tuple(attrValues));
				}
			}

			System.out.println("enter N to stop, Y to to continue");
			choice = input.nextLine().charAt(0);
		} while (choice == 'n' || choice == 'y');
		return this.tuples;

	}
// Method to deleteTuple
	public void deleteTuple(int index) {
		this.tuples.remove(index);
		System.out.println(" Deleted ");
	}

	// Method to updatetuples
	// come back to this to see why its not updating 
	public void updateTuple(int id) {
		Scanner input = new Scanner(System.in);
		HashMap<String, Object> attrValues = new HashMap<String, Object>();
		
		System.out.println("Tuple   (" + this.tuples.get(id).getTupleValues() + ")");
		System.out.println("Insert Tuple  ");
		
		String tuple = input.nextLine();
		String[] values = tuple.split(",");
		
		for (String string : values) {
			System.out.println(string); 
		}
		for (int i = 0; i < this.attributes.size(); i++) {
			attrValues.put(this.attributes.get(i).getName(), values[i]);
		}
		this.tuples.set(id, new Tuple(attrValues));
		
	}
	
// figure out how to print agent relation
	public void printRelation() {
		 System.out.println(Arrays.toString(attributes.toArray()));
		String str = "\nRELATION: " + this.name + "\n\n";
		for (Attribute attr : attributes) {
			str += attr.getName() + "\t";
		}
		str += " ";
		int count = 1;
		for (Tuple tuple : this.tuples) {
			for (Attribute attr : attributes) {
				Object val = tuple.getAttribute(attr.getName());
				str += val + "\t";
			}
			str += "\t" + "\n";
		}
		System.out.println(str);
	}
}


