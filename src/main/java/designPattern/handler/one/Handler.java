package designPattern.handler.one;

public abstract class Handler {

    protected Handler nextHandler;

    protected String name;

    public Handler(String name){
        this.name = name;
    }

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    public abstract void process(DispatherRequest request);
}
