package Networking.mathServerClient.models;

import java.io.Serializable;

public class Response implements Serializable{
    public int statusCode ;
    public double result ;

    public Response(int statusCode,double result){
        this.statusCode = statusCode;
        this.result = result ;
    }
}
