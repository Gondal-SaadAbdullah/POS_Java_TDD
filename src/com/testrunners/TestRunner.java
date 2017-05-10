package com.testrunners;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.testcases.Items_TestAdd;
import com.testcases.Database_Connectivity_Test;
import com.testcases.Items_TestDelete;
import com.testcases.Items_TestUpdate;

public class TestRunner
{

	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(Database_Connectivity_Test.class, Items_TestAdd.class,
				Items_TestUpdate.class, Items_TestDelete.class);

		for (Failure failure : result.getFailures())
		{
			System.out.println("-> " + failure.toString());
		}

		System.out.println("Test Result ::: " + result.wasSuccessful());
	}

}
