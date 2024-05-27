package JSON;

public class Film {
    private String name;
    public Film(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "'" + name + "'";
    }
}
