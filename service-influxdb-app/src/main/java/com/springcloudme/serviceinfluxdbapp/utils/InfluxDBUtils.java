package com.springcloudme.serviceinfluxdbapp.utils;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class InfluxDBUtils {

	private static Logger log = LoggerFactory.getLogger(InfluxDBUtils.class);

	private static String host;

	private static String port;

	private static String uri;

	private static String db;

	private static String username;

	private static String password;

	private InfluxDB instance1;

	@Autowired
	InfluxDBUtils(@Value("${influxdb.host}") String host,@Value("${influxdb.port}") String port,
				  @Value("${influxdb.uri}") String uri,@Value("${influxdb.db}") String db,
				  @Value("${influxdb.username}") String username,@Value("${influxdb.password}") String password){
		this.host = host;
		this.port = port;
		this.uri = uri;
		this.db = db;
		this.username = username;
		this.password = password;
	}

	private static InfluxDBUtils utilInstance = new InfluxDBUtils(host,port,uri,db, username, password);

	public static InfluxDBUtils getInfluxDBUtil() {
		return utilInstance;
	}


	public InfluxDB getInstance(){
		if(instance1 == null){
			return connect();
		}else {
			return instance1;
		}
	}

	public Map<String,Object> insert(InfluxDB instance){
		log.info("in util exec");
		log.info("host="+host+",port="+port+",db="+db+",password="+password+",user="+username+",uri="+uri);

		Map<String,Object> result = new HashMap<>();
		try {
			String rpName = "aRetentionPolicy";
			instance.createRetentionPolicy(rpName, db, "30d", "30m", 2, true);

			Point point2 = Point.measurement("disk")
					.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
					.addField("used", 80L)
					.addField("free", 1L)
					.build();

			log.info("instance",instance);

			instance.write(db,rpName , point2);

			result.put("result",null);

			return result;
		}catch (Exception e){
			e.printStackTrace();
			result.put("result",e.getMessage());
			return result;
		}finally {
			close();
		}
	}

	public Map<String,Object> query(InfluxDB instance, String sql){
		log.info("in util exec");
		log.info("host="+host+",port="+port+",db="+db+",password="+password+",user="+username+",uri="+uri);

		Map<String,Object> result = new HashMap<>();
		try {
			String rpName = "aRetentionPolicy";
			instance.createRetentionPolicy(rpName, db, "30d", "30m", 2, true);
			Query query = new Query(sql,db);

			QueryResult query1 = instance.query(query);

			result.put("result",query1);
			return result;
		}catch (Exception e){
			e.printStackTrace();
			result.put("result",e.getMessage());
			return result;
		}finally {
			close();
		}
	}

	private InfluxDB connect(){
		try {
			return InfluxDBFactory.connect(uri,username,password);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private void close(){
		try {
			InfluxDB instance = getInstance();
			instance.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
