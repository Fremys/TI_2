package dao;

public class CredenciaisDB {

	public final static String driverName = "org.postgresql.Driver";
	//jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
	public final static String username = "gmewnaivbprylb";
	public final static String host = "ec2-100-25-100-81.compute-1.amazonaws.com";
	public final static String dbname = "d1k6bampfd0urr";
	public final static String password = "ee3653ba1ce62068338b9aea2e19c5e633a7648acb000e8fd75cf634c08e4e9d";
	public final static String url = "jdbc:postgresql://"+host+":5432/"+dbname+"?sslmode=require&user="+username+"&password="+password+"";
}
