package top.ipzgo.jvm.stack;

public class StackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF oom = new StackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.printf("\nStack length: %d\n", oom.stackLength);
            throw e;
        }
    }
}
