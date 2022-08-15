package addfarmers;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;

public class AddFarmers {
	private static CqlSession session;
	
	public static void main(String[] args) {
		List<InetSocketAddress> endpointList = new ArrayList<InetSocketAddress>();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",9042);
		endpointList.add(address);
		
		CassandraConnection conn = new CassandraConnection("aaron", "reindeerFlotilla", endpointList, "stackoverflow", "MovingPictures");
		session = conn.getCqlSession();
		
		HashMap<String, String> the_farmer = new HashMap<>();
	    the_farmer.put("Name ", " The name ");
	    the_farmer.put("Farmhouse ", " Varpinge Gard");
	    the_farmer.put("Foods ", " Fruits & Vegetables");

	    List<String> delivery = new ArrayList<>();
	    delivery.add("Malmo Hus parkering");
	    delivery.add("Lund Golfbana Varpinge");


	    insertFarmers(1, the_farmer, delivery);
	}

	private static void insertFarmers(int id, HashMap<String, String> the_farmer, List delivery) {

		//String insert_query = "INSERT INTO farmers (farmer_id, delivery, the_farmer) VALUES ( "
		//             + id + ","
		//             + delivery + ","
		//             + the_farmer + ")";

		String insert_query = "INSERT INTO farmers (farmer_id, delivery, the_farmer) VALUES (?,?,?)";
		PreparedStatement pStatement = session.prepare(insert_query);
		BoundStatement bStatement = pStatement.bind(id, delivery, the_farmer);
		
	    session.execute(bStatement);
	}
}
