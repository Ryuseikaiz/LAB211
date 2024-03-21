package Repository;
import View.WorkerView;

public class WorkerRepository implements IWorkerRepository {
    private final WorkerView data = new WorkerView();

    @Override
    public void addNewWorker() {
        data.addWorker();
    }

    public void SalaryUp() {
        data.upSalary();
    }

    @Override
    public void SalaryDown() {
        data.downSalary();
    }

    @Override
    public void printHistory() {
        data.printListHistory();
    }
}