package kanumuri.shilpa.innerclasses;

import java.io.Closeable;

/**
 * Created by shilpakanumuri on 2/3/17.
 */
interface Connection extends Closeable{

    public String getIp();

    public String getProtocol();

    public String getPort();

    public String connect();

    public void close();

    public boolean getClose();

}
