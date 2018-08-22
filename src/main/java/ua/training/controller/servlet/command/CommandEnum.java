package ua.training.controller.servlet.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new Login();
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
