package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Main.EvaluateUserIncome;
import Main.UserData;

public class EvaluateUserIncomeTest {

	@Test
	public void returnNull() {
		List<UserData> userData = new ArrayList<>();
		Assert.assertTrue(EvaluateUserIncome.process(userData));
	}

}
