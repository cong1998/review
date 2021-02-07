package designPattern.handler.one;

public class PutHandler extends Handler{

    public PutHandler(String name) {
        super(name);
    }

    @Override
    public void process(DispatherRequest request) {
        if("put".equalsIgnoreCase(request.getMethod())){
            System.out.println("method put : "+this.name);
        }else{
            nextHandler.process(request);
        }
    }
}
