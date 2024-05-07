package server.Commands;

import common.Commands.ICommand;
import common.Commands.UserCommand;
import common.net.requests.ServerResponse;
import common.net.requests.ResultState;
import server.Controllers.CollectionController;

/**
 * Class with realization of info command
 * <p>This command is used to print information about collection
 * @see UserCommand
 * @see ICommand
 */
public class InfoCommand extends UserCommand {
    /**
     * InfoCommand constructor
     * <p> Firstly it initializes super constructor by command name, arguments and description
     */
    public InfoCommand() {
        super("info", "print information about collection");
    }

    /**
     * Method to complete info command
     * <p>It prints info from collection controller
     *
     * @return
     */
    @Override
    public ServerResponse execute() {
        return new ServerResponse(ResultState.SUCCESS,
                CollectionController.getInstance().getInfo());
    }
}
