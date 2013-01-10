dataSource {
	//    pooled = true
	//    driverClassName = "org.h2.Driver"
	//    username = "sa"
	//    password = ""

	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"

	//username = "devaccount"
	//password = "devaccount"
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
	development {
		dataSource {
			username = "travelbook"
			password = "travelbook"
			dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:mysql://localhost:3306/travelbook"
			//url = "jdbc:mysql://sql-3.e-clicking.in:3306/bocoumfr_travelbookBD"
		}
	}
	test {
		dataSource {
			username = "travelbook"
			password = "travelbook!"
			dbCreate = "create-drop"
			//url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			url = "jdbc:mysql://ec2-174-129-9-255.compute-1.amazonaws.com:3306/TravelBook"
			//url = "jdbc:mysql://sql-3.e-clicking.in:3306/bocoumfr_travelbookBD"
		}
	}
	production {
		dataSource {
			username = "bocoumfr_travel"
			password = "travelbook"
			dbCreate = "update"
			//url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			url = "jdbc:mysql://sql-3.e-clicking.in:3306/bocoumfr_travelbookBD"
			pooled = true
			properties {
				maxActive = -1
				minEvictableIdleTimeMillis=1800000
				timeBetweenEvictionRunsMillis=1800000
				numTestsPerEvictionRun=3
				testOnBorrow=true
				testWhileIdle=true
				testOnReturn=true
				validationQuery="SELECT 1"
			}
		}
	}
}
