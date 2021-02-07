package designPattern.handler.two;

import designPattern.handler.two.DispatherRequest;
import designPattern.handler.two.Handler;

public class PostHandler extends Handler {

    public PostHandler(String name) {
        super(name);
    }

    @Override
    protected Handler getThisHander() {
        return this;
    }

    @Override
    public void process(DispatherRequest request) {
        if("post".equalsIgnoreCase(request.getMethod())){
            System.out.println("method post : "+this.name);
        }
    }
}
