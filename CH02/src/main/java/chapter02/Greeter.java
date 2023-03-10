package chapter02;

public class Greeter {

    private String fromat;

    public String greet(String name) {
        return String.format(fromat, name);
    }

    public void setFromat(String fromat) {
        this.fromat = fromat;
    }
}
