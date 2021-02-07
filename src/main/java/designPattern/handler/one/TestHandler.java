package designPattern.handler.one;

public class TestHandler {

    public static void main(String[] args) {
        DispatherRequest request = new DispatherRequest();

        GetHandler getHandler = new GetHandler("getHandler");
        PostHandler postHandler = new PostHandler("postHandler");
        PutHandler putHandler = new PutHandler("putHandler");
        DeleteHandler deleteHandler = new DeleteHandler("deleteHandler");

        getHandler.setNextHandler(postHandler);
        postHandler.setNextHandler(putHandler);
        putHandler.setNextHandler(deleteHandler);
        deleteHandler.setNextHandler(getHandler);

        postHandler.process(request);
    }
}
