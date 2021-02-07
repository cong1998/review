package designPattern.handler.two;

import designPattern.handler.two.DeleteHandler;
import designPattern.handler.two.DispatherRequest;
import designPattern.handler.two.GetHandler;
import designPattern.handler.two.PostHandler;
import designPattern.handler.two.PutHandler;

public class TestHandler {

    public static void main(String[] args) throws Throwable {
        DispatherRequest request = new DispatherRequest();
        request.setMethod("delete");
        GetHandler getHandler = new GetHandler("getHandler");
        PostHandler postHandler = new PostHandler("postHandler");
        PutHandler putHandler = new PutHandler("putHandler");
        DeleteHandler deleteHandler = new DeleteHandler("deleteHandler");


        postHandler.start(request);
    }
}
