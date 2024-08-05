package com.scm.scmproject.helpers;

public class ResourceNotfoundException extends  RuntimeException
{
  public  ResourceNotfoundException (String message)
  {
      super(message);

  }



  public ResourceNotfoundException()
  {
      super("user not found");
  }


}
