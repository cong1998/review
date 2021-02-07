package designPattern.handler.one;

public class DeleteHandler extends  Handler{


    public DeleteHandler(String name) {
        super(name);
    }

    @Override
    public void process(DispatherRequest request) {
        if("delete".equalsIgnoreCase(request.getMethod())){
            System.out.println("method delete : "+this.name);
        }else{
            nextHandler.process(request);
        }
    }
}
