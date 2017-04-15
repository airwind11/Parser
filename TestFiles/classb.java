class ClassA extends Police {

    private String message ; // public attribute via setters and getters
    private String bark ;
    protected String foo ;
    protected String bar ;
    private Collection<B> b;
    String test ; // package scope

    public ClassA(String msg , ClassA ferf)
    {

    }
    public ClassA(String msgsdhj)
    {

    }

    public String getMessage(String msg , ClassA ferf) {
        return this.message ;
    }

    public void setMessage( String msg , ClassA ferf) {
        this.message = msg ;
    }

    public static void  testMethod() {
        // do test...
    }
}