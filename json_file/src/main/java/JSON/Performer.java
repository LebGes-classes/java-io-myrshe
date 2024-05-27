package JSON;
import java.util.List;
import java.util.Map;

public class Performer {
    private String name;
    private int numberOfRoles;
    public String getName() {
        return name;
    }
    public int getNumberOfRoles() {
        return numberOfRoles;
    }

    public Performer(String name, int numberOfRoles) {
        this.name = name;
        this.numberOfRoles = numberOfRoles;
    }
    @Override
    public String toString() {
        return "Имя - " + name + ", количество ролей : " + numberOfRoles;
    }
}
