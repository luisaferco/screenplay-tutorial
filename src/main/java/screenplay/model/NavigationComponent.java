package screenplay.model;

public enum NavigationComponent {

    FLIGHTS("Flights"),
    STAYS("Stays"),
    CARS("Cars");

    private final String option;
    private NavigationComponent(String option){
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
