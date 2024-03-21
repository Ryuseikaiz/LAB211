package Model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private boolean isOnlyChild;
    private List<Income> incomes;
    private List<Dependent> dependents;

    public Person(String name, int age, boolean isOnlyChild) {
        this.name = name;
        this.age = age;
        this.isOnlyChild = isOnlyChild;
        this.incomes = new ArrayList<>();
        this.dependents = new ArrayList<>();
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

    public boolean isOnlyChild() {
        return isOnlyChild;
    }

    public void setOnlyChild(boolean onlyChild) {
        isOnlyChild = onlyChild;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public double calculateTaxableIncome() {
        double totalIncome = calculateTotalIncome();
        double deductionForSelf = 11000000;
        double deductionForChildren = calculateChildrenDeduction();
        double deductionForParents = calculateParentsDeduction();

        double taxableIncome = totalIncome - deductionForSelf - deductionForChildren - deductionForParents;
        return taxableIncome > 0 ? taxableIncome : 0;
    }

    public double calculateTaxAmount() {
        double taxableIncome = calculateTaxableIncome();
        double taxAmount;
        if (taxableIncome <= 4000000) {
            taxAmount = taxableIncome * 0.05;
        } else if (taxableIncome <= 6000000) {
            taxAmount = 4000000 * 0.05 + (taxableIncome - 4000000) * 0.1;
        } else if (taxableIncome <= 10000000) {
            taxAmount = 4000000 * 0.05 + 2000000 * 0.1 + (taxableIncome - 6000000) * 0.15;
        } else {
            taxAmount = 4000000 * 0.05 + 2000000 * 0.1 + 4000000 * 0.15 + (taxableIncome - 10000000) * 0.2;
        }
        return taxAmount;
    }

    private double calculateTotalIncome() {
        double totalIncome = 0;
        for (Income income : incomes) {
            totalIncome += income.getAmount();
        }
        return totalIncome;
    }

    private double calculateChildrenDeduction() {
        double deductionForChildren = 0;
        List<Dependent> childDependents = new ArrayList<>();
        for (Dependent dependent : dependents) {
            if (dependent.getType() == DependentType.CHILD) {
                childDependents.add(dependent);
            }
        }
        childDependents.sort((a, b) -> ((Child) b.getDetails()).getAge() - ((Child) a.getDetails()).getAge());
        for (int i = 0; i < Math.min(2, childDependents.size()); i++) {
            Child child = (Child) childDependents.get(i).getDetails();
            if (child.getAge() < 18 || child.isStudying()) {
                deductionForChildren += 4400000;
            } else if (child.getAge() >= 18 && child.getAge() <= 22 && child.isStudying()) {
                deductionForChildren += 6000000;
            }
        }
        return deductionForChildren;
    }

    private double calculateParentsDeduction() {
        double deductionForParents = 0;
        if (isOnlyChild) {
            deductionForParents = 8800000;
        } else {
            int siblingCount = 0;
            for (Dependent dependent : dependents) {
                if (dependent.getType() == DependentType.PARENT) {
                    Parent parent = (Parent) dependent.getDetails();
                    if (parent.getAge() >= 60) {
                        siblingCount++;
                    }
                }
            }
            deductionForParents = 4400000 * siblingCount;
        }
        return deductionForParents;
    }
}
