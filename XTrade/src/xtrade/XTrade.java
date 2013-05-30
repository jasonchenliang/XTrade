package xtrade;

import java.rmi.Remote;

/**
 *
 * @author chenliang
 */
public interface XTrade extends Remote{

    public void hello() throws java.rmi.RemoteException;

}