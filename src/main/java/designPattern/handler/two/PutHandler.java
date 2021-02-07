package designPattern.handler.two;

import designPattern.handler.two.DispatherRequest;
import designPattern.handler.two.Handler;

public class PutHandler extends Handler {

    public PutHandler(String name) {
        super(name);
    }

    @Override
    protected Handler getThisHander() {
        return this;
    }

    @Override
    public void process(DispatherRequest request) {
        if("put".equalsIgnoreCase(request.getMethod())){
            System.out.println("method put : "+this.name);
        }
    }
}
