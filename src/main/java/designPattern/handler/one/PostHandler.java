package designPattern.handler.one;

public class PostHandler extends Handler {

    public PostHandler(String name) {
        super(name);
    }

    @Override
    public void process(DispatherRequest request) {
        if("post".equalsIgnoreCase(request.getMethod())){
            System.out.println("method post : "+this.name);
        }else{
            nextHandler.process(request);
        }
    }
}
