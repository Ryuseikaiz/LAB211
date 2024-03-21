package Model;

import java.text.DecimalFormat;

public class BodyCalModel {

    private double weight;
    private double height;
    private double bmi;
    private String status;

    public BodyCalModel() {
    }

    public BodyCalModel(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setBmi(double height, double weight) {
        this.bmi = weight / (Math.pow(height / 100, 2));
        DecimalFormat df = new DecimalFormat("#.##");
        this.bmi = Double.parseDouble(df.format(this.bmi));
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
