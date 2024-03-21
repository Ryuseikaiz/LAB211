package Model;

public class Child extends Dependent {

    private String name;
    private int age;
    private boolean isStudying;

    public Child(String name, int age, boolean isStudying) {
        super(DependentType.CHILD);
        this.name = name;
        this.age = age;
        this.isStudying = isStudying;
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

    public boolean isStudying() {
        return isStudying;
    }

    public void setStudying(boolean studying) {
        isStudying = studying;
    }
}
