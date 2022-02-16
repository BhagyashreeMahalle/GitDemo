
import Files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js= new JsonPath(payload.CoursePrice());
		
//1. Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);	
		
		
//2. Print Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		
//3. Print Title of the first course
		String firstTitle = js.get("courses[0].title");
		System.out.println(firstTitle);
	
		
//4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++) {
			String courseTitles =js.get("courses["+i+"].title");
			System.out.print(js.get("courses["+i+"].price").toString());
			System.out.println(courseTitles);
		}		
		
		
//5. Print no of copies sold by RPA Course- getting copies only if the Course is RPA
		System.out.println("Print no of copies sold by RPA Course");
		
		for(int i=0;i<count;i++) {
			
			String courseTitles =js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies= js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
			
		}		
		 
		
		
//6. Verify if Sum of all Course prices matches with Purchase Amount

		
	}

}
