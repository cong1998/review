package designPattern.handler.one;

public class GetHandler extends Handler {

    public GetHandler(String name) {
        super(name);
    }

    @Override
    public void process(DispatherRequest request) {
        if("get".equalsIgnoreCase(request.getMethod())){
            System.out.println("method get : "+this.name);
        }else{
            nextHandler.process(request);
        }
    }
}
