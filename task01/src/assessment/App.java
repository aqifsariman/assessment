package assessment;

import java.io.IOException;

public final class App {

    public static void main(String[] args) throws IOException {
        String fileName = "../../" + args[0];
        FileHandler fH = new FileHandler();
        fH.readFile(fileName);
    }
}
