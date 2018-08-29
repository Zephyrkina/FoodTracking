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
    SHOWALLFOOD {
        {
            this.command = new ShowAllFood();
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
    SAVEPREVIOUSRECORDS {
        {
            this.command = new SavePreviousRecords();
        }
    },
    SHOWTODAYSFOODLIST {
        {
            this.command = new ShowTodaysFoodList();
        }
    },
    REGISTRATION {
        {
            this.command = new Registration();
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
