package client.Commands;

import client.net.UDPClient;
import common.Commands.UserCommand;
import common.net.dataTransfer.PackedCommand;
import common.net.requests.*;

import java.util.ArrayList;

/**
 * Class with realization of show command for client
 * <p>This command is used to print all elements of collection
 * @see UserCommand
 */
public class ShowCommand extends ClientCommand {

    /**
     * ShowCommand constructor
     * <p> Firstly it initializes super constructor by command name, arguments and description
     */
    public ShowCommand() {
        super("show", "print all elements of collection");
    }

    /**
     * Method to complete show command
     * <p>It gets collection from collection controller and then prints it
     * <p>If collection is empty user is informed
     */
    @Override
    public ServerResponse execute() {
        return sendAndReceive();
    }
}
