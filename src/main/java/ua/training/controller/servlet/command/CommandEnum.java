package ua.training.controller.servlet.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new Login();
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
    EDITFOOD {
        {
            this.command = new EditFood();
        }
    },
    DELETEFOOD {
        {
            this.command = new DeleteFood();
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
    CHANGELANGUAGE {
        {
            this.command = new ChangeLanguage();
        }
    },
    PROFILE{
        {
            this.command = new Profile();
        }
    },
    LOGOUT{
        {
            this.command = new Logout();
        }
    };


    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
