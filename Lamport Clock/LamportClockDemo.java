import java.util.concurrent.atomic.AtomicInteger;

class LamportClock {
    private AtomicInteger clock;

    public LamportClock() {
        clock = new AtomicInteger(0);
    }

    public void tick() {
        clock.incrementAndGet();
    }

    public void sendAction() {
        // Increment the clock before sending a message
        tick();
    }

    public void receiveAction(int sentTime) {
        // Update the clock by taking the maximum of the current time and the received time + 1
        clock.set(Math.max(clock.get(), sentTime) + 1);
    }

    public int getTime() {
        return clock.get();
    }
}

public class LamportClockDemo {
    public static void main(String[] args) {
        LamportClock clock = new LamportClock();

        // Simulate events in a distributed system
        simulateEvent(clock, "Event A");
        simulateEvent(clock, "Event B");
        simulateEvent(clock, "Event C");
    }

    private static void simulateEvent(LamportClock clock, String eventName) {
        // Some processing time for the event
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform the event, and update the clock
        clock.sendAction();
        System.out.println(eventName + " executed at Lamport time: " + clock.getTime());

        // Simulate the event being received and processed by another node
        int sentTime = clock.getTime();
        // Some processing time for receiving and handling the event
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clock.receiveAction(sentTime);
        System.out.println(eventName + " received at Lamport time: " + clock.getTime());
    }
}
