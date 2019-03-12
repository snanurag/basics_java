package annotations;

public @interface SimulatingNull {

    public int id() default -1;

    public String description();
}

@interface SQLString {
    public SimulatingNull simulatingNull() default @SimulatingNull(description = "");
}
