package Model;

public class Parent extends Dependent {

    private String name;
    private int age;
    private String relationship;

    public Parent(String name, int age, String relationship) {
        super(DependentType.PARENT);
        this.name = name;
        this.age = age;
        this.relationship = relationship;
    }

    public Object getDetails() {
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
