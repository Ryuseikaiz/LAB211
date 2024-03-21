package Model;

public abstract class Dependent {

    private DependentType type;

    public Dependent(DependentType type) {
        this.type = type;
    }

    public abstract Object getDetails();

    public DependentType getType() {
        return type;
    }

    public void setType(DependentType type) {
        this.type = type;
    }
}
