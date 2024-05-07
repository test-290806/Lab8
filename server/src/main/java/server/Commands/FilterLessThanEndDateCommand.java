package server.Commands;

import common.Commands.ICommand;
import common.Commands.UserCommand;
import common.net.requests.ServerResponse;
import common.net.requests.ResultState;
import server.Controllers.CollectionController;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Class with realization of filter_less_than_end_date command
 * <p>This command is used to print all elements whose endDate is less than given
 * @see UserCommand
 * @see ICommand
 */
public class FilterLessThanEndDateCommand extends UserCommand {
    private LocalDateTime endDate;
    /**
     * FilterLessThanEndDateCommand constructor
     * <p> Firstly it initializes super constructor by command name, arguments and description
     */
    public FilterLessThanEndDateCommand() {
        super("filter_less_than_end_date", "print all elements whose endDate is less than given", "endDate");
    }

    /**
     * Method to complete filter_less_than_end_date command
     * <p>It reads endDate from user and then print all elements whose endDate is less than given
     * <p>If collection is empty endDate is not read (except script mode)
     *
     * @return
     */
    @Override
    public ServerResponse execute() {
        if(CollectionController.getInstance().isEmpty()){
            return new ServerResponse(ResultState.SUCCESS, "Collection is empty!");
        }
        return new ServerResponse(ResultState.SUCCESS,
                CollectionController.getInstance().getLessThanEndDate(endDate).toString());
    }

    @Override
    public void initCommandArgs(ArrayList<Serializable> arguments) {
        this.endDate = (LocalDateTime) arguments.get(0);
    }
}
