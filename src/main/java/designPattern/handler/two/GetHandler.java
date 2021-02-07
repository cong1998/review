package designPattern.handler.two;

import designPattern.handler.two.DispatherRequest;
import designPattern.handler.two.Handler;

public class GetHandler extends Handler {

    public GetHandler(String name) {
        super(name);
    }

    @Override
    protected Handler getThisHander() {
        return this;
    }

    @Override
    public void process(DispatherRequest request) {
        if("get".equalsIgnoreCase(request.getMethod())){
            System.out.println("method get : "+this.name);
        }
    }
}
