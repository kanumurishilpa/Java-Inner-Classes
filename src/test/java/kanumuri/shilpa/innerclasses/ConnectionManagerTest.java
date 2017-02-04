package kanumuri.shilpa.innerclasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shilpakanumuri on 2/3/17.
 */
public class ConnectionManagerTest {

    ConnectionManager connectionManager;

    @Before
    public void setUp(){
        connectionManager = new ConnectionManager();
    }

    @Test
    public void createNewConnectionWithDefaultProtocolTest(){
        Connection connection1 = connectionManager.createNewConnection("120.0.0.0","8000");
        Assert.assertTrue(connectionManager.connectionList.contains(connection1));

    }

    @Test
    public void createNewConnectionTest(){
        Connection connection1 = connectionManager.createNewConnection("120.0.0.0","8000","https");
        Assert.assertTrue(connectionManager.connectionList.contains(connection1));
    }

    @Test
    public void requestingTooManyConnetionsTest(){
        connectionManager.createNewConnection("120.0.0.0","8000");
        connectionManager.createNewConnection("120.0.0.1","8001","https");
        connectionManager.createNewConnection("120.0.0.2","8002","https");
        connectionManager.createNewConnection("120.0.0.3","8003","https");
        connectionManager.createNewConnection("120.0.0.4","8004","https");
        Connection connection = connectionManager.createNewConnection("120.0.0.6","8000","https");
        Assert.assertEquals(null,connection);
    }

    @Test
    public void getIPValueFromRequestedconnectionTest(){
        Connection connection = connectionManager.createNewConnection("120.0.0.0","8000");
        Assert.assertEquals("120.0.0.0",connection.getIp());
    }

    @Test
    public void getPortValueFromRequestedconnectionTest(){
        Connection connection = connectionManager.createNewConnection("120.0.0.0","8000");
        Assert.assertEquals("8000",connection.getPort());
    }

    @Test
    public void getProtocolValueFromRequestedconnectionTest(){
        Connection connection = connectionManager.createNewConnection("120.0.0.0","8000");
        Assert.assertEquals("http",connection.getProtocol());
    }

    @Test
    public void closedConnectionTest(){
        Connection connection = connectionManager.createNewConnection("120.0.0.0","8000");
        connection.close();
        Assert.assertEquals(true,connection.getClose());
    }


}
