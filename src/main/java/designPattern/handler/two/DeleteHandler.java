package designPattern.handler.two;

import designPattern.handler.two.DispatherRequest;
import designPattern.handler.two.Handler;

public class DeleteHandler extends Handler {


    public DeleteHandler(String name) {
        super(name);
    }

    @Override
    protected Handler getThisHander() {
        return this;
    }

    @Override
    public void process(DispatherRequest request) {
        if("delete".equalsIgnoreCase(request.getMethod())){
            System.out.println("method delete : "+this.name);
        }
    }
}
