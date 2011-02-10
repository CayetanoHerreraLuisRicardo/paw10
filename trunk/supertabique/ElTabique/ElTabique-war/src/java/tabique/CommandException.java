/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

class CommandException extends Exception
{
  String error;
//----------------------------------------------
// Default constructor - initializes instance variable to unknown
  public CommandException()
  {
    super();             // call superclass constructor
    error = "unknown";
  }

//-----------------------------------------------
// Constructor receives some kind of message that is saved in an instance variable.
  public CommandException(String err)
  {
    super(err);     // call super class constructor
    error = err;  // save message
  }

//------------------------------------------------
// public method, callable by exception catcher. It returns the error message.
  public String getError()
  {
    return error;
  }
}