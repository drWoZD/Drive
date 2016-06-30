package org.net;

import java.io.*;
import java.net.*;

public class Sender
{
    public Sender()
    {
        socket = new Socket();
    }

    public Sender(String address, int port) throws IOException
    {
        socket = new Socket();
        //socket = new Socket(InetAddress.getByName("192.168.23.10") ,port);
        this.address = InetAddress.getByName(address);
        this.port = port;
        //inStream = new DataInputStream(socket.getInputStream());
        //outStream = new DataOutputStream(socket.getOutputStream());
    }

    public void setAddress(String address) throws UnknownHostException
    {
        this.address = InetAddress.getByName(address);
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void connect() throws IOException
    {
        socket = new Socket(address ,port);
        inStream = new DataInputStream(socket.getInputStream());
        outStream = new DataOutputStream(socket.getOutputStream());
    }

    public void disconnect() throws IOException
    {
        socket.close();
    }

    public boolean isConnect()
    {
        return (socket.isConnected() && !socket.isClosed());
    }

    public void send(String data) throws IOException
    {
        if (socket.isConnected() && !socket.isClosed())
            outStream.writeUTF(data);
    }

    private Socket socket;
    private InetAddress address;
    private int port;
    private DataInputStream inStream;
    private DataOutputStream outStream;
}
