package net.wendal.nutzbook;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import net.wendal.nutzbook.bean.User;

public class MainSetup implements Setup{

	@Override
	public void destroy(NutConfig conf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(NutConfig conf) {
		Ioc ioc = conf.getIoc();
		Dao dao = ioc.get(Dao.class);
		Daos.createTablesInPackage(dao, "net.wendal.nutzbook", false);
		if(dao.count(User.class)==0){
			User user = new User();
			user.setName("zhangsan");
			user.setPassword("123");
			dao.insert(user);
		}
	}

}
