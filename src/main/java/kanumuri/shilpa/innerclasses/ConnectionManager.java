package kanumuri.shilpa.innerclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shilpakanumuri on 2/3/17.
 */
public class ConnectionManager {

    ManagedConnection managedConnection;
    List<ManagedConnection> connectionList = new ArrayList<ManagedConnection>();
    final int limitNumberOfConnections;

    public ConnectionManager(){
        limitNumberOfConnections = 5;
    }

    public Connection createNewConnection(String ip,String port){
        if(numberOfOpenConnection() < limitNumberOfConnections){
            managedConnection = new ManagedConnection(ip,port,"http");
            connectionList.add(managedConnection);
            return managedConnection;
        }
        return null;
    }

    public Connection createNewConnection(String ip,String port,String protocol){
        if(numberOfOpenConnection() < limitNumberOfConnections){
            managedConnection = new ManagedConnection(ip,port,"http");
            connectionList.add(managedConnection);
            return managedConnection;
        }
        return null;
    }

    public int numberOfOpenConnection(){
        int openConnections = 0;
        for(ManagedConnection connection: connectionList){
            if(connection.close == false){
                openConnections = openConnections + 1;
            }
        }
        return openConnections;
    }

    private class ManagedConnection implements Connection{

        String ip;
        String port;
        String protocol;
        Boolean close = false;


        public ManagedConnection(String ip, String port, String protocol) {
            this.ip = ip;
            this.port = port;
            this.protocol = protocol;
            this.close = false;
        }

        public ManagedConnection() {
            this.ip = "null";
            this.port = "null";
            this.protocol = "null";
            this.close = false;
        }

        public String getIp() {
            if(close == true){
                return "Connection IP closed";
            }
            return ip;
        }

        public String getPort() {
            if(close == true){
                return "Connection IP closed";
            }
            return port;
        }

        public String getProtocol() {
            if(close == true){
                return "Connection protocol closed";
            }
            return protocol;
        }

        public String connect(){
            if(close == true){
                return "Connection closed";
            }
            return getIp()+ ":" +getPort() + " via " +getProtocol();
        }

        public void close(){
            this.close = true;
        }

        public boolean getClose(){
            return close;
        }


    }

}
