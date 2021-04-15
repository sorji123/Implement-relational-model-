package project_one_Database;
//Returns sum, max, min, and avg of user given attribute

public abstract class Aggregate {
	public abstract void start();
    public abstract void update(Tuple t);
    public abstract Tuple end();

    public static Aggregate min(String attrValues, String attrname) {
        return null;
    }

    public static Aggregate max(String attrValues, String attrname) {
        return null;
    }

    public static Aggregate avg(String attrValues, String attrname) {
        return null;
    }

    public static Aggregate sum(String attrValues, String attrname) {
        return null;
    }
     

}