package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollege {

	public static void main(String[] args) throws Exception {

		testAdd();
		// testUpdate();
		// testDelete();
		// testSearch();
        // testfindByName()

	}

	public static void testAdd() throws Exception {

		CollegeBean bean = new CollegeBean();

		bean.setName("Hritik");
		bean.setAddress("Indore");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhoneNo("9891456289");
		bean.setCreatedBy("rajl@gmail.com");
		bean.setModifiedBy("aryan@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		CollegeBean bean = new CollegeBean();

		bean.setName("Suraj");
		bean.setAddress("Indore");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhoneNo("9893907064");
		bean.setCreatedBy("suraj1412@gmail.com");
		bean.setModifiedBy("suraj1412@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		CollegeModel model = new CollegeModel();
		model.delete(1);
	}

	public static void testfindByName() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByName("DAVV");

		if (bean != null) {
			System.out.print(" " + bean.getId());
			System.out.print(" " + bean.getName());
			System.out.print(" " + bean.getAddress());
			System.out.print(" " + bean.getState());
			System.out.print(" " + bean.getCity());
			System.out.print(" " + bean.getPhoneNo());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());
		} else {
			System.out.println(" id not found ");
		}

	}

	public static void testSearch() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setId(1);
		// bean.setName("m");

		CollegeModel model = new CollegeModel();
		List list = model.search(bean, 1, 1);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (CollegeBean) it.next();
			System.out.print(" " + bean.getId());
			System.out.print(" " + bean.getName());
			System.out.print(" " + bean.getAddress());
			System.out.print(" " + bean.getState());
			System.out.print(" " + bean.getCity());
			System.out.print(" " + bean.getPhoneNo());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());

		}
	}
}