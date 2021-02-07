package designPattern.handler.two;

import java.util.LinkedList;
import java.util.List;

public abstract class Handler {

    private static List<Handler> handlerList = new LinkedList<>();

    protected  String name;

    public Handler(String name){
        this.name = name;
        handlerList.add(getThisHander());
    }

    protected abstract Handler getThisHander();

    protected abstract void process(DispatherRequest request);

    public void start(DispatherRequest request){
        for (int i = 0; i < handlerList.size(); i++) {
            handlerList.get(i).process(request);
        }
    }
}
