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
    FINDFOODBYNAME {
        {
            this.command = new FindFoodByName();
        }
    },
    ADDFOODTODAILYRECORD {
        {
            this.command = new AddFoodToDailyRecord();
        }
    },
    SAVERECORDTODIARY {
        {
            this.command = new SaveRecordToDiary();
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
