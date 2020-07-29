package top.ipzgo.jvm.gc;

public class FinalizeGC {

    public static FinalizeGC SAVE_HOOK;

    public void isAlive() {
        System.out.println("Yes , i am still alive.");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method firing.");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, i am dead.");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, i am dead.");
        }
    }
}

