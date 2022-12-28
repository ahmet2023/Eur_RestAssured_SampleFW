package com.visa.eur.runners;


import com.visa.eur.tests.ReqResAPITest;
import org.junit.platform.suite.api.*;

// good article: https://howtodoinjava.com/junit5/junit5-test-suites-examples/

@Suite //this is a-must
@SelectPackages("com.visa.eur.tests") // run the tests package
//to run on specific tag. we need to add below:
//@IncludeTags("reqAPI") //this must work with @SelectPackages("com.visa.eur.tests")
//@IncludeTags("hello")


//OTHER OPTIONS: See below.

//@SuiteDisplayName("Smoke Test")
//@SelectPackages("com.visa.eur.tests.ReqResAPITest")   // just to run ReqResAPITest
//@SelectPackages( {"com.visa.eur.tests" , "com.visa.eur.regression" }  ) // tests and regression packages
//@SelectPackages("com.visa.eur.tests") // tests package
//@SelectClasses( ReqResAPITest.class )  // I just want to run BaseAuthTest
//Class level tag
//@IncludeTags({ "test1", "test2" })  // look for anything that tagged with test1 and test2
//@IncludeTags("db")  // this is class level tag

//@ExcludeTags("flowers")  // it will exclude this tag
//@IncludeTags("newsAPI")


public class API_Runner {
}
