package Networking.mathServerClient.models;

import java.io.Serializable;

public class Request implements Serializable{
    public Operation op;
    public double a;
    public double b;

    public Request(Operation op,double a,double b){
        this.op = op;
        this.a = a;
        this.b = b ;
    }
}
