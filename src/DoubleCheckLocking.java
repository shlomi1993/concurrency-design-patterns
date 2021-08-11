class Helper {
    Helper() {
        System.out.println("This is very helpful");
    }
}

// Double-Check Locking.
// Create a singleton in a multi-threaded program.
class Singleton1 {
    private volatile Helper helper;
    public Helper getHelper() {
        Helper result = helper;
        if (result == null) {
            synchronized(this) {
                result = helper;
                if (result == null) {
                    helper = result = new Helper();
                }
            }
        }
        return helper;
    }
}

// ClassHolder.
// Create a singleton in a multi-threaded program.
class Singleton2 {
    private static class HelperHolder {
        public static final Helper helper = new Helper();
    }
    public static Helper getHelper() {
        return HelperHolder.helper;
    }
}

class Main {
    public static void main(String[] args) {
        Helper h = Singleton2.getHelper();
    }
}
