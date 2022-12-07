import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public abstract class CPUScheduler {
    protected final Deque<Process> processes = new LinkedList<>();

    protected int currentTime = 0;
    protected int finished = 0;
    protected boolean switching = false;
    protected final List<Interval> executionOrder = new ArrayList<>();

    public void start(List<Process> processes) {
//        System.out.println("Scheduling started");
        do {
//            System.out.println("  At time " + this.currentTime + ":");
            this.step(processes);
            this.currentTime++;
        } while (processes.size() != this.finished);
    }

    protected abstract void step(List<Process> processes);
}
