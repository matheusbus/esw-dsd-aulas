package dsd.socket.request;

public abstract class RequestHandlerService {

    private Object response;

    protected abstract void handleRequest(String methodStr, String request);

    protected abstract void get(String request);
    protected abstract void list(String request);
    protected abstract void insert(String request);
    protected abstract void update(String request);
    protected abstract void delete(String request);
    protected String extractIdFromRequest(String request) {
        return request.split(";")[2];
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
