package com.manulaiko.blackeye.net.game;

import java.net.Socket;

import com.manulaiko.blackeye.launcher.Main;

import com.manulaiko.tabitha.Console;

/**
 * Game server
 *
 * Starts game server
 *
 * @author Manulaiko <manulaiko@gmail.com>
 *
 * @package com.manulaiko.blackeye.net.game
 */
public class Server extends com.manulaiko.tabitha.net.Server
{

    /**
     * Packet factory
     */
    public com.manulaiko.blackeye.net.game.packets.Factory packetFactory;

    /**
     * Constructor
     */
    public Server()
    {
        super(Main.configuration.getShort("core.game_port"));

        this.packetFactory = new com.manulaiko.blackeye.net.game.packets.Factory();
    }

    /**
     * Waits for connections and handles them
     */
    public void onRunning()
    {
        try {
            Socket socket = this.acceptConnection();
            this.addConnection(new Connection(socket));

            Console.println("Received connection from "+ socket.getInetAddress().getHostAddress());
        } catch(Exception e) {
            //Empty
        }
    }

    /**
     * Stops the server
     *
     * @param timeout Timeout to wait before stopping the server
     */
    public void stop(int timeout)
    {
        try {
            super.stop();
        } catch(java.io.IOException e) {
            //Empty
        }
    }
}
