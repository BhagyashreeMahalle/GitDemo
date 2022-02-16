import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses() 
	{
		//6. Verify if Sum of all Course prices matches with Purchase Amount

		int sum=0;
		JsonPath js= new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");

		for(int i=0;i<count;i++) {
			int coursePrices =js.get("courses["+i+"].price");
			int courseCopies =js.get("courses["+i+"].copies");
			int amount = coursePrices*courseCopies;
			
			System.out.println(amount);
			sum=sum+amount;	
		}	
		System.out.println(sum);
		
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}

}
