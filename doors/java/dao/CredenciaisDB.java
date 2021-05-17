package dao;

public class CredenciaisDB {

	public final static String driverName = "org.postgresql.Driver";
	//jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
	public final static String username = "hthhrueqnhmzoz";
	public final static String host = "ec2-23-21-229-200.compute-1.amazonaws.com";
	public final static String dbname = "d6pp43g0q7u4k3";
	public final static String password = "b397ac30ed22c0d47692dae821fb1984380ac30a5278392df5dc0638c5070631";
	public final static String url = "jdbc:postgresql://"+host+":5432/"+dbname+"?sslmode=require&user="+username+"&password="+password+"";
}
