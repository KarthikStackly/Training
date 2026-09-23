class NegativeTimeNotAllowedException extends Exception {

    public NegativeTimeNotAllowedException(String err) { //define the constructor accepting error message
        super(err); //super is passing the err args to the parent class so to use its built-in constructor/method
    }
}

public class UDException {
    public enum TrafficLights { RED, YELLOW, GREEN }; //simple enum declared

    static TrafficLights showLight(int seconds) throws NegativeTimeNotAllowedException {
        if(seconds < 0) {
            throw new NegativeTimeNotAllowedException(seconds + " => Time cannot be negative...");
        }

        if (seconds >= 5) return TrafficLights.RED;
        if (seconds >= 1) return TrafficLights.YELLOW;
        return TrafficLights.GREEN;
    }

    static void main() {
        int[] testTimes = {7, 2, 0, -3}; // Sneak in an invalid time in a simple array of seconds

        for (int time : testTimes) {
// try-catch to expect that exception and handle it in our own way
            try {
                TrafficLights light = showLight(time);
                System.out.printf("Time: %d sec -> Signal: %s%n", time, light);
            } catch (NegativeTimeNotAllowedException e) {
// This block runs ONLY when the custom exception is thrown
                System.err.println("ERROR: " + e.getMessage());
            }
        }
    }
}
