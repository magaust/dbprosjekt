package model;

public class Exercise {

	private int id;
    private String name;
    private String description;
    private boolean isMachine;
	
    public Exercise(int id, String name, String description, boolean machine) {
    		this.id = id;
    		this.name = name;
    		this.description = description;
    		this.isMachine = machine;
    }
    
    public int getId() {
    		return id;
    }
    
    public String getName() {
    		return name;
    }
    
    public String getDescription() {
    		return description;
    }

    public boolean getIsMachine() { return isMachine; }
}
