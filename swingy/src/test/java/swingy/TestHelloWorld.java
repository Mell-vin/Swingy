package swingy;

import org.testng.annotations.Test;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;


public class TestHelloWorld {
	
	public void just(String name) {
		System.out.println("Name is " + name);
	}

	@Test
	public void testHelloWorld() {
		this.just("Lwazi");
	}
}
