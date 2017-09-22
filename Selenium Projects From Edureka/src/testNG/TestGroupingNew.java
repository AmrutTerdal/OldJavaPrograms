package testNG;

import org.testng.annotations.Test;

public class TestGroupingNew {
	@Test(groups={"B"})
	public void M1() {
	}

	@Test(groups={"D"})
	public void M2() {
	}

	@Test(groups={"D"})
	public void M3() {
	}

	@Test(groups={"D"})
	public void M4() {
	}

	@Test(groups={"A"})
	public void M5() {
	}

	@Test(groups={"A"})
	public void M6() {
	}

}
