package designPattern.handler.two;

public class DispatherRequest {

    private String method;

    private int number;

    public DispatherRequest(){
        this.method = "get";
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) throws Throwable {
        if(!method.matches("post|get|put|delete")){
            throw new Throwable("不被允许的method");
        }
        this.method = method;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
