package dsd.socket.request;

public interface RequestHandlerService {

    void handleRequest(String methodStr, String request);

    Object getResponse();
}
