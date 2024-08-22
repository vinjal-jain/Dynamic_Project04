package in.co.rays.test;



import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.FacultyBean;
import in.co.rays.model.FacultyModel;

public class TestFaculty {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		//testDelete();
		

	}

	public static void testAdd() throws Exception {

		FacultyBean bean = new FacultyBean();
		
		bean.setId(1);
		bean.setFirstName("");
		bean.setLastName("");
		bean.setDob(new Date());
		bean.setGender("");
		bean.setMobileNo("");
		bean.setEmail("");
		bean.setCollegeId(2);
		bean.setCollegeName("");
		bean.setCourseId(3);
		bean.setCourseName("");
		bean.setSubjectId(4);
		bean.setSubjectName("");
		bean.setCreatedBy("rajl@gmail.com");
		bean.setModifiedBy("aryan@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		FacultyBean bean = new FacultyBean();
		

		bean.setId(1);
		bean.setFirstName("");
		bean.setLastName("");
		bean.setDob(new Date());
		bean.setGender("");
		bean.setMobileNo("");
		bean.setEmail("");
		bean.setCollegeId(2);
		bean.setCollegeName("");
		bean.setCourseId(3);
		bean.setCourseName("");
		bean.setSubjectId(4);
		bean.setSubjectName("");
		bean.setCreatedBy("rajl@gmail.com");
		bean.setModifiedBy("aryan@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();
		model.update(bean);


	}

	public static void testDelete() throws Exception {

		FacultyModel model = new FacultyModel();
		model.delete(1);
	}

		public static void testFindByPk() throws Exception {
			FacultyModel model = new FacultyModel();
			FacultyBean bean = model.findbypk(1);
			if (bean != null) {
				System.out.print(" " + bean.getId());
				System.out.print(" " + bean.getFirstName());
				System.out.print(" " + bean.getLastName());
				System.out.print(" " + bean.getDob());
				System.out.print(" " + bean.getGender());
				System.out.print(" " + bean.getMobileNo());
				System.out.print(" " + bean.getEmail());
				System.out.print(" " + bean.getCollegeId());
				System.out.print(" " + bean.getCollegeName());
				System.out.print(" " + bean.getCourseId());
				System.out.print(" " + bean.getCourseName());
				System.out.print(" " + bean.getSubjectId());
				System.out.print(" " + bean.getSubjectName());
				System.out.print(" " + bean.getCreatedBy());
				System.out.print(" " + bean.getModifiedBy());
				System.out.print(" " + bean.getCreatedDatetime());
				System.out.print(" " + bean.getModifiedDatetime());
			} else {
				System.out.println(" id not found ");
			}

		}

		public static void testSearch() throws Exception {

			FacultyBean bean = new FacultyBean();
			bean.setId(1);
			// bean.setName("m");

			FacultyModel model = new FacultyModel();
			List list = model.search(bean, 1, 1);
			Iterator i = list.iterator();
			while (i.hasNext()) {
				bean = (FacultyBean) i.next();
				System.out.print(" " + bean.getId());
				System.out.print(" " + bean.getFirstName());
				System.out.print(" " + bean.getLastName());
				System.out.print(" " + bean.getDob());
				System.out.print(" " + bean.getGender());
				System.out.print(" " + bean.getMobileNo());
				System.out.print(" " + bean.getEmail());
				System.out.print(" " + bean.getCollegeId());
				System.out.print(" " + bean.getCollegeName());
				System.out.print(" " + bean.getCourseId());
				System.out.print(" " + bean.getCourseName());
				System.out.print(" " + bean.getSubjectId());
				System.out.print(" " + bean.getSubjectName());
				System.out.print(" " + bean.getCreatedBy());
				System.out.print(" " + bean.getModifiedBy());
				System.out.print(" " + bean.getCreatedDatetime());
				System.out.print(" " + bean.getModifiedDatetime());


			}
		}
	}