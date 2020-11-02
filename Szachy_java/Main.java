import java.security.InvalidAlgorithmParameterException;
import ii.po.szachy.core.Gra;

public class Main {
    public static void main(String args[]) throws InvalidAlgorithmParameterException {
        Gra.init();
        Gra.loop();
    }
}