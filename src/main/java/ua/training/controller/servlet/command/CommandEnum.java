package ua.training.controller.servlet.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new Login();
        }
    },
    SHOWALLUSERSCOMMAND {
        {
            this.command = new ShowAllUsersCommand();
        }
    },
    ADDOWNFOOD {
        {
            this.command = new AddOwnFood();
        }
    },
    LOGOUT{
        {
            this.command = new Logout();
        }
    };


  /*  LOGIN (new Login()),
    LOGOUT ( new Logout());*/

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
