package in.co.rays.test;



import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.TimetableBean;
import in.co.rays.model.TimetableModel;

public class TestTimetable {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		//testDelete();
		

	}

	public static void testAdd() throws Exception {

		TimetableBean bean = new TimetableBean();
		
		
		
		bean.setId(1);
		bean.setSemester("");
		bean.setDescription("");
		bean.setExamDate(new Date());
		bean.setExamTime("");
		bean.setCourseId(2);
		bean.setCourseName("");
		bean.setSubjectId(2);
		bean.setSubjectName("");
        bean.setCreatedBy("rajl@gmail.com");
		bean.setModifiedBy("aryan@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		TimetableModel model = new TimetableModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		TimetableBean bean = new TimetableBean();
		

		bean.setId(1);
		bean.setSemester("");
		bean.setDescription("");
		bean.setExamDate(new Date());
		bean.setExamTime("");
		bean.setCourseId(2);
		bean.setCourseName("");
		bean.setSubjectId(2);
		bean.setSubjectName("");
        bean.setCreatedBy("rajl@gmail.com");
		bean.setModifiedBy("aryan@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		TimetableModel model = new TimetableModel();
		model.update(bean);


	}

	public static void testDelete() throws Exception {

		TimetableModel model = new TimetableModel();
		model.delete(1);
	}

		public static void testFindByPk() throws Exception {
			TimetableModel model = new TimetableModel();
		TimetableBean bean = model.findByPk(1);
			if (bean != null) {
				System.out.print(" " + bean.getId());
				System.out.print(" " + bean.getSemester());
				System.out.print(" " + bean.getDescription());
				System.out.print(" " + bean.getExamDate());
				System.out.print(" " + bean.getExamTime());
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

			TimetableBean bean = new TimetableBean();
			bean.setId(1);
			// bean.setName("m");

			TimetableModel model = new TimetableModel();
			List list = model.search(bean, 1, 1);
			Iterator i = list.iterator();
			while (i.hasNext()) {
				bean = (TimetableBean) i.next();
				System.out.print(" " + bean.getId());
				System.out.print(" " + bean.getSemester());
				System.out.print(" " + bean.getDescription());
				System.out.print(" " + bean.getExamDate());
				System.out.print(" " + bean.getExamTime());
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