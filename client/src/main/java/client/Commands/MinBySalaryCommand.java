package client.Commands;

import client.net.UDPClient;
import common.Commands.UserCommand;
import common.net.dataTransfer.PackedCommand;
import common.net.requests.*;

import java.util.ArrayList;

/**
 * Class with realization of min_by_salary command for client
 * <p>This command is used to print any element from collection which salary field is minimal
 * @see UserCommand
 */
public class MinBySalaryCommand extends ClientCommand {
    /**
     * MinBySalaryCommand constructor
     * <p> Firstly it initializes super constructor by command name, arguments and description
     */
    public MinBySalaryCommand() {
        super("min_by_salary", "print any element from collection which salary field is minimal");
    }

    /**
     * Method to complete min_by_salary command
     * <p>It prints element with minimal salary
     * <p>If collection is empty user is informed
     */
    @Override
    public ServerResponse execute() {
        return sendAndReceive();
    }
}
