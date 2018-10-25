package test;

import exceptions.*;
import info.SignIn;
import info.SignUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ExceptionsTest {

    SignIn si;
    SignUp su;
    @BeforeEach
    public void init()
    {
         si = new SignIn();
         su = new SignUp();
    }
    @Test
    public void testSignInSuccessful()
    {
        try{
            si.signIn("mental","institute");
            fail("No Exception Created");
        } catch (PasswordDoesNotMatchException e) {
           fail("PasswordDoesNotMatchException Caught");
        } catch (UserDoesNotExistException e) {
            fail("UserDoesNotExistException Caught");
        } catch (SignInSuccessfulException e) {
            //Success If Caught - No Further Action
        }
    }

    @Test
    public void testSignInWrongPassword()
    {
        try{
            si.signIn("mental","asylum");
            fail("No Exception Created");
        } catch (PasswordDoesNotMatchException e) {
            //Success If Caught - No Further Action
        } catch (UserDoesNotExistException e) {
            fail("UserDoesNotExistException Caught");
        } catch (SignInSuccessfulException e) {
            fail("SignInSuccessfulException Caught");
        }
    }

    @Test
    public void testSignInUserDoesNotExist()
    {
        try{
            si.signIn("pencil","pens");
            fail("No Exception Created");
        } catch (PasswordDoesNotMatchException e) {
            fail("PasswordDoesNotMatchException Caught");
        } catch (UserDoesNotExistException e) {
            //Success If Caught - No Further Action
        } catch (SignInSuccessfulException e) {
            fail("SignInSuccessfulException Caught");
        }
    }

    @Test
    public void testSignUpUserAlreadyExists()
    {
        try {
            su.signUp("mental", "institute");
        } catch (SignUpSuccessfulException e) {
            fail("SignUpSuccessfulException Caught");
        }
        catch (UserAlreadyExistsException e) {
            //Success If Caught - No Further Action
        }catch (GenericException e) {
            fail("GenericException Caught");
        }
    }


}
