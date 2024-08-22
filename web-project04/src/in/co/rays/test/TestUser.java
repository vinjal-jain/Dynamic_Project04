package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// testSearch();
		//testAdd();
		 testUpdate();
		// testDelete();
		// testfindByPk();
		// testAuth();
	}

	public static void testAdd() throws Exception {
		UserBean bean = new UserBean();

		bean.setFirstName("Rohit");
		bean.setLastName("Bais");
		bean.setLogin("rohit03@gmail.com");
		bean.setPassword("12345");
		bean.setConfirmPassword("12345");
		bean.setDob(new Date());
		bean.setMobileNo("9981597443");
		bean.setRoleId(103L);
		bean.setGender("male");
		bean.setCreatedBy("Self");
		bean.setModifiedBy("Self");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		UserBean bean = new UserBean();

		bean.setFirstName("Sandeep");
		bean.setLastName("Verma");
		bean.setLogin("sandeep@gmail.com");
		bean.setPassword("1432");
		bean.setConfirmPassword("1432");
		bean.setDob(new Date());
		bean.setMobileNo("9981597443");
		bean.setRoleId(105L);
		bean.setGender("male");
		bean.setCreatedBy("auth");
		bean.setModifiedBy("auth");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(103);
		UserModel model = new UserModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(2);
	}

	public static void testfindByPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(1);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print(" " + bean.getFirstName());
			System.out.print(" " + bean.getLastName());
			System.out.print(" " + bean.getLogin());
			System.out.print(" " + bean.getPassword());
			System.out.print(" " + bean.getConfirmPassword());
			System.out.print(" " + bean.getDob());
			System.out.print(" " + bean.getMobileNo());
			System.out.print(" " + bean.getRoleId());
			System.out.print(" " + bean.getGender());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());
		} else {
			System.out.println("id not found...!");
		}

	}

	public static void testAuth() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.authenticate("madhu@gmail.com", "123");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print(" " + bean.getFirstName());
			System.out.print(" " + bean.getLastName());
			System.out.print(" " + bean.getLogin());
			System.out.print(" " + bean.getPassword());
			System.out.print(" " + bean.getConfirmPassword());
			System.out.print(" " + bean.getDob());
			System.out.print(" " + bean.getMobileNo());
			System.out.print(" " + bean.getRoleId());
			System.out.print(" " + bean.getGender());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());
		} else {
			System.out.println("login and password not found");
		}

	}

	public static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		UserBean bean = new UserBean();
		// bean.setId(1);
		bean.setDob(sdf.parse("2024/08/11"));
		// bean.setFirstName("m");

		UserModel model = new UserModel();
		List list = model.search(bean, 1, 2);
		Iterator i = list.iterator();

		while (i.hasNext()) {

			bean = (UserBean) i.next();

			System.out.print(bean.getId());
			System.out.print(" " + bean.getFirstName());
			System.out.print(" " + bean.getLastName());
			System.out.print(" " + bean.getLogin());
			System.out.print(" " + bean.getPassword());
			System.out.print(" " + bean.getConfirmPassword());
			System.out.print(" " + bean.getDob());
			System.out.print(" " + bean.getMobileNo());
			System.out.print(" " + bean.getRoleId());
			System.out.print(" " + bean.getGender());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());

		}

	}
}