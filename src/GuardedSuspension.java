class GameCharacter {
    boolean victory;
    int score;
    synchronized void victoryDance() {
        while (!victory) {
            try { wait(); }
            catch (InterruptedException ignored) { }
        }
        // Actual task implementation
        // victory dance!!
    }
    synchronized void updateScore(int x) {
        // ...
        // Inform waiting threads
        notify();
    }
}