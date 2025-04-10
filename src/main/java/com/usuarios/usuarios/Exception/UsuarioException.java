package com.usuarios.usuarios.Exception;

public class UsuarioException extends Exception {
    private int httpStatusCode;

    public UsuarioException(String mensaje) {
        super("mensaje:" + mensaje);
    }
    public UsuarioException(String mensaje, int httpStatusCode) {
        super("mensaje: " + mensaje);
        this.httpStatusCode = httpStatusCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
