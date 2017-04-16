class ClassA extends Police {

    private  static String message ; // public attribute via setters and getters
    private String bark ;
    protected String[] foo ;
    private ArrayList<String> dsf;
    private int[] ff;
    protected String bar ;
    private Collection<String> b;
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