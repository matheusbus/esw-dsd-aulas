package dsd.socket.request;

import dsd.socket.protocol.Method;

import java.util.List;

public abstract class RequestHandlerService {

    private Object response;

    final void handleRequest(String methodStr, String request) {
        Method method = Method.fromString(methodStr);

        // VAI CHAMAR OS MÉTODOS PARA CADA TIPO DE MÉTODO
        switch (method) {
            case GET:
                get(request);
                break;
            case LIST:
                list(request);
                break;
            case INSERT:
                insert(request);
                break;
            case UPDATE:
                update(request);
                break;
            case DELETE:
                break;
        }
    }
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
