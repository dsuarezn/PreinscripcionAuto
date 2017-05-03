package co.edu.udistrital.sga.preinscripcion.auto.web.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonMessage {

    protected String Mensaje;

    public JsonMessage() {
    }

    public JsonMessage(String text) {
        this.Mensaje = text;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String text) {
        this.Mensaje = text;
    }
}