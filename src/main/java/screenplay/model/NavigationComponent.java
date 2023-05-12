package screenplay.model;

public enum NavigationComponent {

    FLIGHTS("flights"),
    STAYS("stays"),
    CARS("cars");

    private final String option;
    private NavigationComponent(String option){
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
